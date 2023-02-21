# prueba
 Lista de reproduccion
end points

Post: Para crear lista de reproduccion
http://localhost:8081/app/api/lists
{
    "nombre": "lista2",
    "descripcion": "lista 2 primera prueba"
}
{
    "nombre": "lista1",
    "descripcion": "lista 1 primera prueba"
}
{
    "nombre": "lista3",
    "descripcion": "lista 3 primera prueba"
}
{
    "nombre": "lista4",
    "descripcion": "lista 4 primera prueba"
}
{
    "nombre": "lista5",
    "descripcion": "lista 5 primera prueba"
}
GET: obtener listas
http://localhost:8081/app/api/lists


DELETE: eliminar listas
http://localhost:8081/app/api/lists/{nombre}

GET: POR NOMBRE RETORNA DESCRIPCION
http://localhost:8081/app/api/lists/{nombre}



POST: CANCIONES AGREGAR EN LISTAS EXISTENTES.

http://localhost:8081/app/api/canciones

JSON
{
    "titulo":"cancion21",
    "artista":"Robert",
    "album":"num21",
    "anno": 2024,
    "listaReproduccion": {
        "id": {Id de lista ya creada anteriormente}
    },
    "genero": "rock"
}

JSON DE EJEMPLO
{
    "titulo":"cancion21",
    "artista":"Robert",
    "album":"num21",
    "anno": 2024,
    "listaReproduccion": {
        "id": 1
    },
    "genero": "rock"
}
