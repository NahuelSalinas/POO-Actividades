package com.voidweb.imcapp;

public class CalculadoraIMC {
    private double peso; 
    private double altura; 
    
    public CalculadoraIMC(double peso, double altura){
        this.peso = peso;
        this.altura = altura; 
    }
    
    public double calcularIMC(){
        if(altura <= 0){
            throw new IllegalArgumentException("La altura debe ser mayor a cero.");
        }
        
        return peso / (altura * altura);
    }
    
    public String categoria(){
        double imc = calcularIMC();
        if (imc < 18.5){
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 24.9){
            return "Peso saludable";
        } else if (imc >= 25 && imc < 30){
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
    
    public String consejo() {
        String cat = categoria();
        switch (cat) {
            case "Bajo peso":
                return "Consume más calorías: incluye frutos secos\ny legumbres en tu dieta.";
            case "Peso saludable":
                return "Sigue así: mantén una dieta y ejercicio.\n¡Buen trabajo!";
            case "Sobrepeso":
                return "Haz ejercicio moderado y controla\ntu ingesta de carbohidratos.";
            default: // Obesidad
                return "Consulta un profesional y aumenta\ntu actividad física gradualmente.";
        }
    }
}
