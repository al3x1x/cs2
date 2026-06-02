 ALEXIS GONZÁLEZ SANCHEZ

SUSTENTACIÓN DE DISEÑO DE DOMINIO Y ARQUITECTURA -

1. Justificación del Modelo de Dominio (Entidades y Objetos de Valor)
- Entidad ('Affected'): El individuo afectado por el Mirakuru se diseñó estrictamente como una Entidad de Dominio en la clase 'Affected'. Posee una identidad única global representada por el atributo 'id', y su estado es mutable y continuo a lo largo del tiempo (su nombre, ubicación y nivel de agresividad pueden variar mediante operaciones PUT, pero sigue manteniendo su identidad biológica y de registro en el sistema).
- Objeto de Valor ('riskLevel'): Para esta versión del sistema, el nivel de riesgo se modeló como un Objeto de Valor implícito encapsulado en un tipo de dato 'String'. No posee una identidad única independiente y se define enteramente por su valor. Su cálculo está centralizado en el Servicio de Dominio de manera determinista: si 'aggressivenessLevel > 7', el sistema le asigna de forma fija e inmutable el valor "CRITICAL - HIGH". Esto asegura consistencia tanto al registrar (POST) como al actualizar (PUT).

2. Aplicación de Principios SOLID y Desacoplamiento Hexagonal
El diseño de la aplicación cumple con el Principio de Inversión de Dependencias (DIP):
- La capa de Dominio es el corazón del sistema y es completamente agnóstica de la tecnología externa. Define los puertos (interfaces) 'ManageAffectedUseCase' y 'AffectedPort'.
- La capa de Infraestructura aloja los adaptadores de entrada ('AffectedController') y de salida ('AffectedRepositoryAdapter' junto con Spring Data JPA). 
El controlador REST pertenece estrictamente a la infraestructura y solo se encarga de acoplar el protocolo HTTP, delegando toda la orquestación del negocio al caso de uso. De este modo, si en el futuro se decide cambiar el motor de persistencia (de SQL Server a una base de datos NoSQL) o el framework web, el núcleo lógico del equipo de Oliver Queen permanecerá intacto y escalable.
