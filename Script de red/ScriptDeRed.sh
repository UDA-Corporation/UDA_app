#!/bin/bash

#Nodo para hacer ping
TARGET="8.8.8.8"

#Fichero log
LOG="ConnectionResults.log"

ping -n -c 4 -i 10 -W 5 $TARGET
#Ping de 4 paquetes cada 10 segundos, esperar 5 segundos como maximo
if [$? -eq 0]
    then
        #Hay conexion
        echo "Node: $TARGET - ($date +%F\ %T) - Successful" &>> $LOG
    else
        #No hay respuesta
        echo "Node: $TARGET - ($date +%F\ %T) - Failed" &>> $LOG
fi


##Estructura de error (no respuesta)
##Node: nodo - 2018-04-19 11:02:34 - Failed

##Estructura de conexion satisfactoria
##Node: nodo - 2018-04-19 11:02:34 - Successful


#####################                                   MIRAR EL DE TEST
