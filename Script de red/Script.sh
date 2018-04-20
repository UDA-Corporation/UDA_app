#!/bin/bash
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v0.3 alpha

By UDA Corp. under MIT license
"
#Indicamos cual sera el fichero log
LOG="ConnectionResults.log"
echo "Los resultados se guardarán en el fichero "ConnectionResults.log""
#Nodos para hacer ping
TARGET="10.1.1.1"
TARGET2="10.1.2.1"
TARGET3="10.1.3.1"
TARGET4="10.1.11.1"
TARGET5="10.1.10.1"
#Hacemos el ping e indicamos si ha habido conexion o no a cada nodo
if ping -n -c 4 $TARGET >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion
        echo "Node: $TARGET - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion mostramos el log al usuario y matamos el proceso
        echo "Node: $TARGET - $(date +%F\ %T) - Failed - Check status of the node $TARGET!" >> $LOG
        cat ConnectionResults.log
fi
if ping -n -c 4 $TARGET2 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion
        echo "Node: $TARGET2 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion mostramos el log al usuario y matamos el proceso
        echo "Node: $TARGET2 - $(date +%F\ %T) - Failed - Check status of the node $TARGET2!" >> $LOG
        cat ConnectionResults.log
fi
if ping -n -c 4 $TARGET3 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion
        echo "Node: $TARGET3 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion mostramos el log al usuario y matamos el proceso
        echo "Node: $TARGET3 - $(date +%F\ %T) - Failed - Check status of the node $TARGET3!" >> $LOG
        cat ConnectionResults.log
fi
if ping -n -c 4 $TARGET4 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion
        echo "Node: $TARGET4 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion mostramos el log al usuario y matamos el proceso
        echo "Node: $TARGET4 - $(date +%F\ %T) - Failed - Check status of the node $TARGET4!" >> $LOG
        cat ConnectionResults.log
fi
if ping -n -c 4 $TARGET5 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion
        echo "Node: $TARGET5 - $(date +%F\ %T) - Successful" >> $LOG
        echo "" >> $LOG
    else
        #No hay conexion mostramos el log al usuario y matamos el proceso
        echo "Node: $TARGET5 - $(date +%F\ %T) - Failed - Check status of the node $TARGET5!" >> $LOG
        echo "" >> $LOG
        cat ConnectionResults.log
fi
