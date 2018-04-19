#!/bin/bash

#Nodo para hacer ping introducirdo por el usuario
echo "Por favor, introduzca la direccion del nodo a comprobar (Ejemplo: "8.8.8.8")"
read TARGET

#Fichero log
LOG="ConnectionResults.log"

#Comunicamos al usuario que espere
echo "Realizando "test" de red, espere por favor"
#For para comprobar todos los nodos

if ping -n -c 4 $TARGET >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion
        echo "Node: $TARGET - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion
        echo "Node: $TARGET - $(date +%F\ %T) - Failed" >> $LOG
fi


read -p "Test realizado, ¿desea realizar la comprobacion a otro nodo? (S/N): " respuesta

if "$respuesta" == "S"
    then
        echo "Funciona" #exec "$Test"
    else
        exit
fi

##Estructura de error (no conexion)
##Node: nodo - 2018-04-19 11:02:34 - Failed

##Estructura de conexion satisfactoria
##Node: nodo - 2018-04-19 11:02:34 - Successful
