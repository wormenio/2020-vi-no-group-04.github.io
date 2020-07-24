## Validación de contraseñas
* Patrón implementado: Strategy
* Ventajas:
    * Flexibilidad. Permite que se incorporen nuevas validaciones a futuro ( es requerimiento del sistema)
    * Cohesión. Cada clase tiene una responsabilidad acotada. 
    * Testeabilidad. Se puede testear cada validación de forma desacoplada del resto.
    
### Diagrama de clases
![Diagrama de Clases de la cuarta iteracion](http://www.plantuml.com/plantuml/png/fSwnYiCm30RWtK-XyMx94nmXa8ovvI2tgx5Q1BOSB3bBwRitb0O2AHsQLTB_wM_KC5k9mOq1LM7GWfaJN1q0zApsyu-1FUOsYMLK4iOQvjqCtCsjsQggOPy2nsAKppZIY-tZtvpOmuf_VI-aUzRQN7PquW0Sfq2HnFGTjhLMgazoOIl-buKZ7e06wNYHqY3O1fpf0DLYnj4ea_xHHCO-wITQG-9B37S0)

### TPA 3
![Diagrama de Clases Tercera iteración](http://www.plantuml.com/plantuml/png/ZL9DRzim3BtxLmWvTHyki7iG56jQeCE61SF-024n7W59z2IvXmNzxnDZnPNjeiZ9zdjyZtoaxsA2a0Pd6_89mn4qgWUVo80vDI-DjX2ZUkW2HZurglrECMsV4hguKoIFZ1q2FoCQ3gg_l6Nq1tiqeDpvaR_th0U7Fl4zEmoQm2gpWaI7XdYF1-XOkTTtSO24weZwZzWTBKDIv7eE2Nzpojf6VUemhVkCqzzy6Fb7CPX3LSiv8RuB-HupPB42CT7V8QDXmbwQozuADJBg9F6WtsesrF5dWr47wZMntutcb_fOsKD-xI1SgB6b9KT-1hus_ONddLGzdtp23eC2JrnzEfJhpMOK-b4sAtTBd5izOoY6wtZta8qu49GVHfgza_0SSTB48f90Kyg95NJAkOIXjwGXpzLPgAXg1SB40uIIAfv45XReJPdWJM7XlWs1J6vM6IoOQro-GaIrjX1u9YytQzkTMfnbTWCfs7pSg3UvszlTGbiwY6fricO9Y7wzl_VBLjkwibpoDpz31vx-WVma9TXYxenistRpPQFgskOElHcS_Gy0)
* 15. Se debe permitir crear usuarios para la aplicación, con dos tipos de usuarios: administrador y estándar
    
    
        Por ahora no tienen comportamiento, entonces por ahora seá un tipo ENUM
        
      