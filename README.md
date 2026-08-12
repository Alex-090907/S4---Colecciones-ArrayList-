# S4 - Colecciones (ArrayList)

Este proyecto lo hice para la materia de Programación Orientada a Objetos. Es un programa en Java que corre por consola y permite manejar estudiantes y sus calificaciones a través de un menú.

## Qué hace el programa

El menú tiene 5 opciones:

1. **Estudiantes**: registrar un estudiante nuevo (cédula, nombre, apellido) o listar los que ya están.
2. **Calificaciones**: registrar las notas de un estudiante (3 aportes y examen) o listarlas todas.
3. **Notas por Estudiante**: buscas a un estudiante por su cédula y te muestra sus notas junto con el promedio final y si está aprobado o reprobado.
4. **Notas por Aporte**: eliges un aporte específico (aporte 1, 2, 3 o examen) y te muestra ese valor para todos los estudiantes registrados, más el promedio del grupo.
5. **Salir**.

## Cómo calculé la nota final

Usé la fórmula de promedio de los tres aportes por 70%, más el examen por 30%. Si la nota final da 7 o más, se considera aprobado.

## Estructura del proyecto

```
src
 ├── clases
 │    ├── estudiante.java
 │    └── nota.java
 └── principal
      └── Main.java
```

Las clases `estudiante` y `nota` son las que nos dieron en la guía de la materia, no las modifiqué. Toda la lógica del menú la hice en la clase `Main`, dentro del paquete `principal`.

## Cómo correrlo

Se abre el proyecto en Eclipse y se ejecuta la clase `Main.java` (Run As > Java Application).

## Video explicativo

[https://www.youtube.com/watch?v=Wn71fJFllLI](https://www.youtube.com/watch?v=Wn71fJFllLI)

