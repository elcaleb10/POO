/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diagramaejerciciodeherencia;

import java.time.LocalDate;

/**
 *
 * @author CalebZG
 */
public class Persona {

    private String nombre;
    private String correo;
    private LocalDate fechaNacimiento;//=LocalDate.now();

    //public Persona(){}
//    public Persona(String nombre){
//        setNombre(nombre);
//        System.out.println("Construyendo una persona");
//    }
    public Persona(String nombre, String correo, LocalDate fechaNac) {
        setNombre(nombre);
        setCorreo(correo);
        setFechaNacimiento(fechaNac);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        /*23 - 06 -2023 ACT
        01 - 07 - 2000 NAC*/
        //Identificar si el mes de nacimiento no ha pasado
        if (fechaNacimiento.getMonthValue() > fechaActual.getMonthValue()) {
            edad--;
            //Estamos en el mes del cumpleaños
        } else if (fechaNacimiento.getMonthValue() == fechaActual.getMonthValue()) {
            //Identificar si el dia de nacimiento no ha pasado
            if (fechaNacimiento.getDayOfMonth() > fechaActual.getDayOfMonth()) {
                edad--;
            }
        }

        return edad;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        //Verificar que los objetos sean del mismo tipo
        //Para evitar una excepcion al hacer casting 
        //El objeto a comparar y this aon de tipo de dato identico
//        if(obj.getClass() != this.getClass()){
//            return false;
//        }
        //El objeto a comparar y this son de "parecido"(son parte de la misma 
        //jerarquia de herencia)
        if(!(obj instanceof Persona)){
            return false;
        }
        Persona otraPersona = (Persona) obj;
        if (this.getNombre().equalsIgnoreCase(otraPersona.getNombre())) {
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "Persona\nNombre: " + nombre + "\nCorreo: " + correo +
                "\nFecha Nacimiento: " + fechaNacimiento;
    }

}