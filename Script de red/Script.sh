#!/bin/bash
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v1.1

By UDA Corp. under MIT license
"
#Indicamos cual sera el fichero log
LOG="ConnectionResults.log"
#Nodos para hacer ping
TARGET="10.1.1.1"
TARGET2="10.1.2.1"
TARGET3="10.1.3.1"
TARGET4="10.1.11.1"
TARGET5="10.1.10.1"
TARGET6="8.8.8.8"
NODE=("$TARGET" "$TARGET2" "$TARGET3" "$TARGET4" "$TARGET5" "$TARGET6")
#Hacemos el ping e indicamos si ha habido conexion o no a cada nodo
for item  in ${NODE[*]}
do
    if ping -n -c 1 $item >/dev/null #Ping de 1 paquete
        then
            #Hay conexion, se guarda en el log el mensaje
            echo "Node: $item - $(date +%F\ %T) - Successful" >> $LOG
        else
            #No hay conexion y mostramos el aviso al usuario para que mire el log
            echo "Node: $item - $(date +%F\ %T) - Failed - Check status of the node $item!" >> $LOG
            echo "Error in the connection of node $item, check "ConnectionResults.log" for more details"
    fi
done
echo " " >>$LOG
