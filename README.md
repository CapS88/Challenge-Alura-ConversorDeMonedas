
# Conversor de Monedas

Este proyecto fue desarrollado para el programa **One de Alura** en asociación con **Oracle "Next Education"** por Carlos P.

---

## Descripción

Este proyecto es una aplicación de consola desarrollada en **Java** que permite realizar conversiones de moneda en tiempo real. Utiliza una API externa para obtener las tasas de cambio actualizadas y guarda un registro de las conversiones realizadas en un archivo de texto.

---

## Características

- Conversión entre diferentes monedas utilizando una API externa.
- Validación de montos ingresados por el usuario.
- Registro de las conversiones en un archivo de texto (`conversion.txt`) con un formato legible.
- Manejo de excepciones para entradas inválidas o problemas de conexión.

---

## Tecnologías Utilizadas

- **Java**
- **HttpClient**: Para realizar solicitudes HTTP.
- **Gson**: Para procesar la respuesta JSON de la API.
- **ExchangeRate-API**: Fuente de las tasas de cambio.
- **Manejo de Archivos**: Para registrar las conversiones realizadas

---

## Estructura del Proyecto

- **Principal**: Clase principal que inicia el programa.
- **MenuUsuario**: Clase que controla la interacción con el usuario y maneja el flujo del programa.
- **ConversionDeMonedas**: Clase encargada de realizar las conversiones utilizando una API externa.
- **GeneradorDeArchivos**: Clase que guarda las conversiones realizadas en un archivo de texto.
- **ResultadoApi**: `record` utilizado para encapsular los datos obtenidos de la API.

---


## Ejemplo de Uso

1. Al iniciar el programa, se presenta un menú con las opciones disponibles.
2. El usuario selecciona una opción e ingresa el monto a convertir.
3. El resultado se muestra en la consola y se puede volver a convertir o salir.
4. Al salir del programa, el usuario vera un mensaje confirmando que las conversiones fueron guardadas.
5. El archivo `conversion.txt` contiene las conversiones realizadas.