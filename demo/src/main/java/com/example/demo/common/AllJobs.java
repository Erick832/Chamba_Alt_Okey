package com.example.demo.common;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ExceptionMessageEnum;
import lombok.Data;

@Data
public class AllJobs {
    private String name;
    private String type;
    public AllJobs(Long IdEmployment){
        if(IdEmployment.intValue()==1)
        {
            this.name="Carpintero";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==2){
            this.name="Cerrajero";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==3){
            this.name="Mecanico";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==4){
            this.name="Pescador";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==5){
            this.name="Albañil";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==6){
            this.name="Plomero";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==7){
            this.name="Soldador";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==8){
            this.name="Pintor";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==9){
            this.name="Sastre";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==10){
            this.name="Vendedor";
            this.type="Oficio";
        }
        else if(IdEmployment.intValue()==11){
            this.name="Abogado";
            this.type="Profesión";
        }
        else if(IdEmployment.intValue()==12){
            this.name="Programador";
            this.type="Profesión";
        }
        else if(IdEmployment.intValue()==13){
            this.name="Ingeniero Civil";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==14){
            this.name="Administrador";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==15){
            this.name="Periodista";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==16){
            this.name="Secretaria";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==17){
            this.name="Electricista";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==18){
            this.name="Arquitecto";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==19){
            this.name="Psicólogo";
            this.type="Profesion";
        }
        else if(IdEmployment.intValue()==20){
            this.name="Geógrafo";
            this.type="Profesion";
        }





        else {
            throw new BadRequestException(ExceptionMessageEnum.JOB_NOT_FOUND.getMessage());
        }
    }
}
