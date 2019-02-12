# ESPECIFICACIÓN DE LOS CAMPOS DE LOS MENSAJES

## Obtener lista de usuarios conectados

```text
   | Comando|| token|| destino de la peticion ||objeto |
    ---------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Destino peticion: Es el usuario que estara esperando una respuesta
Objeto: Es el objeto, de tipo lista que sera enviada al usuario destino.
```

## Obtener lista solicitudes de usuario

```text
   | Comando|| token|| destino de la peticion ||objeto |
    ---------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Destino peticion: Es el usuario que estara esperando una respuesta
Objeto: Es el objeto, de tipo lista que sera enviada al usuario destino.
```

## Enviar un mensaje

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||mensaje|
    -------------------------------------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Id mensaje: Es un codigo unico, asignado a la hora de enviar un mensaje
Destino del mensaje: Es el usuario que estara esperando una respuesta
Origen del mensaje:Es el usuario que ha realizado el envio del mensaje
Mensaje: Mensaje enviado.
```

## Enviar un archivo

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||Nombre archivo||Contenido archivo|
    --------------------------------------------------------------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Id mensaje: Es un codigo unico, asignado a la hora de enviar un mensaje
Destino del mensaje: Es el usuario que estara esperando una respuesta
Origen del mensaje:Es el usuario que ha realizado el envio del mensaje
Nombre archivo: Es el nombre del archivo que sera enviado.
Contenido archivo: Es el contenido del archivo, codificado en base 64, que sera enviado.
```

## Enviar un meme

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||Nombre meme|
    ----------------------------------------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Id mensaje: Es un codigo unico, asignado a la hora de enviar un mensaje
Destino del mensaje: Es el usuario que estara esperando una respuesta
Origen del mensaje:Es el usuario que ha realizado el envio del mensaje
Nombre meme: Es el nombre del meme que sera enviado.
```

## Enviar una imagen

```text
   | Comando|| token||id mensaje||destino del mensaje||Origen del mensaje||Nombre imagen||Contenido archivo|
    --------------------------------------------------------------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Id mensaje: Es un codigo unico, asignado a la hora de enviar un mensaje
Destino del mensaje: Es el usuario que estara esperando una respuesta
Origen del mensaje:Es el usuario que ha realizado el envio del mensaje
Nombre imagen: Es el nombre de la imagen que sera enviado.
Contenido archivo: Es el contenido del archivo, codificado en base 64, que sera enviado.
```

## Enviar una Solicitud

```text
   | Comando|| token||destino de la solicitud||Origen Solicitud||Mensaje|
    --------------------------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor    
Destino de la solicitud: Es el usuario al cual sera enviada la solicitud
Origen de la solicitud:Es el usuario que ha realizado el envio de la solicitud
Mensaje: Mensaje con la palabra "Agregar" al usuario solicitado.
```

## Respuesta

```text
   | Comando|| token||Id respuesta||Comando a responder||destino de respuesta||Estado|
    ---------------------------------------------------------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Id respuesta: Es un codigo unico, asignado a la hora de enviar una respuesta
Comando a responder: Es el comando que ha generado una peticion y se le noticara su estado.
Destino de respuesta: Es el usuario al cual sera enviada la respuesta de la peticion realizada.
Estado: Es el codigo que sera enviado al destino identificado.
```

## Desconectarse

```text
   | Comando|| token||origen||Estado|
    --------------------------------
Comando: Es la palabra con la cual se indentifica cual sera la peticion que se enviara al servidor.
Token: Es el identificador del usuario conectado al servidor
Origen: Es el usuario que solicita desconectarse.
Estado: Es el codigo que sera enviado como respuesta al destino identificado.
```

