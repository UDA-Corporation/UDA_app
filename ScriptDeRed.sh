#!/bin/bash

#Nodo para hacer ping
TARGET="nodo"

#Fichero log
LOG="Resultados.log"

#Ping de 4 paquetes cada 10 segundos, esperar 5 segundos como maximo
PING=$(ping -n -c 4 -i 10 -W 5 $TARGET 2>&1)

if [[ $? !=0 ]]
then
    if [[$PING =~ "loss"]]
    then
        #No hay respuesta
        ERROR=$(echo "$PING" | grep 'loss')
        echo "Nodo: $TARGET - ($date +%F\ %T) - Failed - $ERROR" &>> $LOG
    else
        #Hay conexion
        r
        SUCCESS=$(echo "$PING" | grep '')
        echo "Nodo: $TARGET - ($date +%F\ %T) - Successful - $SUCCESS" &>> $LOG
    fi

fi


##Estructura de error (no respuesta)
##Nodo: nodo - 2018-04-19 11:02:34 - Failed - 4 packets transmitted, 0 received, 100% packet loss, time XXms

##Estructura de conexion satisfactoria
##Nodo: nodo - 2018-04-19 11:02:34 - Successful - 4 packets transmitted, 4 received, 0% packet loss, time XXms
