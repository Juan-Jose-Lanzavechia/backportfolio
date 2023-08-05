package com.portfolio.portfolio.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolio.Dto.DtoExperiencia;
import com.portfolio.portfolio.Entity.Experiencia;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.SExperiencia;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins="http://localhost:4200")
   public class CExperiencia {
      @Autowired
      SExperiencia sExperiencia;
 
      //Vamos a traer una lista, la cual nos traiga todas las experiencias   
      @GetMapping("/lista") 
      public ResponseEntity<List<Experiencia>> list(){
      List<Experiencia> list= sExperiencia.list();
      return new ResponseEntity(list,HttpStatus.OK);
      }   


      @GetMapping("/detail/{id}")
      public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
      }


         //Puesto con el signo de interrogación, significa que puede recibir cualquier cosa.
      @PostMapping("/create") //Para crear una nueva experiencia
      public ResponseEntity<?> create (@RequestBody DtoExperiencia dtoexp){
   
      if(StringUtils.isBlank(dtoexp.getNombreE()))
      return new ResponseEntity(new Mensaje("Es obligatorio un nombre"),HttpStatus.BAD_REQUEST); 

      if (sExperiencia.existsByNombreE(dtoexp.getNombreE())) /* Acá vamos a poner el nombre de la experiencia. Si ese 
      nombre ya existe porque ya lo hemos cargado previamente, va a salir el mensaje de que esa experiencia
      ya existe y que, por lo tanto, no podemos repetirla. */
      return new ResponseEntity(new Mensaje ("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

      Experiencia experiencia= new Experiencia(dtoexp.getNombreE(),dtoexp.getDescripcionE());
      sExperiencia.save(experiencia);
      return new ResponseEntity(new Mensaje("Nueva experiencia agregada"), HttpStatus.OK); 
   }


      //Para actualizar datos de experiencia. Además, validamos si el id existe
      @PutMapping("/update/{id}")
      public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoExperiencia dtoexp){
        
         if(!sExperiencia.existsById(id))
         return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);

            /* Para comparar nombre de las experiencias: las que queremos agregar con las que ya tenemos agregadas.
            Si un nombre coincide nos tiene que decir que ese nombre ya existe. */
         if(sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() !=id )
            return new ResponseEntity(new Mensaje("Ya existe esa experiencia"), HttpStatus.BAD_REQUEST);
         
            //Para indicar que los campos no pueden estar vacíos
         if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            //Busca el nombre que está en el dto y lo setea al objeto experiencia de tipo Experiencia
            Experiencia experiencia= sExperiencia.getOne(id).get();
            experiencia.setNombreE(dtoexp.getNombreE()); 
            experiencia.setDescripcionE((dtoexp.getDescripcionE()));

            sExperiencia.save(experiencia);
            return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

      }

      //Para eliminar experiencia
      @DeleteMapping("/delete/{id}") 
      public ResponseEntity<?> delete(@PathVariable("id") int id) {
         if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
            sExperiencia.delete(id);

            return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

      }
}
 