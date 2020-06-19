## Validación de contraseñas
* Patrón implementado: Strategy
* Ventajas:
    * Flexibilidad. Permite que se incorporen nuevas validaciones a futuro ( es requerimiento del sistema)
    * Cohesión. Cada clase tiene una responsabilidad acotada. 
    * Testeabilidad. Se puede testear cada validación de forma desacoplada del resto.
    
### Diagrama de clases
![Diagrama de Clases de la cuarta iteracion](http://www.plantuml.com/plantuml/png/fSwnYiCm30RWtK-XyMx94nmXa8ovvI2tgx5Q1BOSB3bBwRitb0O2AHsQLTB_wM_KC5k9mOq1LM7GWfaJN1q0zApsyu-1FUOsYMLK4iOQvjqCtCsjsQggOPy2nsAKppZIY-tZtvpOmuf_VI-aUzRQN7PquW0Sfq2HnFGTjhLMgazoOIl-buKZ7e06wNYHqY3O1fpf0DLYnj4ea_xHHCO-wITQG-9B37S0)

### TPA 1
* 15. Se debe permitir crear usuarios para la aplicación, con dos tipos de usuarios: administrador y estándar
    
    
        Por ahora no tienen comportamiento, entonces por ahora seá un tipo ENUM
        
      