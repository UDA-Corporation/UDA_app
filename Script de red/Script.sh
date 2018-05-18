#!/bin/bash
#To repeat the script---> crontab -e (to open crontab) and put    in the file. Save.
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v1.2

By UDA Corp. under MIT license
"
echo "The results will be saved in "ConnectionResults.log""
#Indicamos cual sera el fichero log y le anadimos cabecera
LOG="ConnectionResults.log"
echo "
Result(s) of the test(s)

IMPORTANT: If you are seeing this because it popped up asking you for it, check the last lines of this file to see the nodes affected
" >> $LOG
#Nodos para hacer ping
TARGET="10.1.1.1"
TARGET2="10.1.2.1"
TARGET3="10.1.3.1"
TARGET4="10.1.11.1"
TARGET5="10.1.10.1"
TARGET6="8.8.8.8"
#Hacemos el ping e indicamos si ha habido conexion o no a cada nodo
if ping -n -c 4 $TARGET >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion, se guarda en el log el mensaje
        echo "Node: $TARGET - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion y mostramos el aviso al usuario para que mire el log
        echo "Node: $TARGET - $(date +%F\ %T) - Failed - Check status of the node $TARGET!" >> $LOG
        echo "Error in the connection of node $TARGET, check "ConnectionResults.log" for more details"
fi
if ping -n -c 4 $TARGET2 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion, se guarda en el log el mensaje
        echo "Node: $TARGET2 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion y mostramos el aviso al usuario para que mire el log
        echo "Node: $TARGET2 - $(date +%F\ %T) - Failed - Check status of the node $TARGET2!" >> $LOG
        echo "Error in the connection of node $TARGET2, check "ConnectionResults.log" for more details"
fi
if ping -n -c 4 $TARGET3 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion, se guarda en el log el mensaje
        echo "Node: $TARGET3 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion y mostramos el aviso al usuario para que mire el log
        echo "Node: $TARGET3 - $(date +%F\ %T) - Failed - Check status of the node $TARGET3!" >> $LOG
        echo "Error in the connection of node $TARGET3, check "ConnectionResults.log" for more details"
fi
if ping -n -c 4 $TARGET4 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion, se guarda en el log el mensaje
        echo "Node: $TARGET4 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion y mostramos el aviso al usuario para que mire el log
        echo "Node: $TARGET4 - $(date +%F\ %T) - Failed - Check status of the node $TARGET4!" >> $LOG
        echo "Error in the connection of node $TARGET4, check "ConnectionResults.log" for more details"
fi
if ping -n -c 4 $TARGET5 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion, se guarda en el log el mensaje
        echo "Node: $TARGET5 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion y mostramos el aviso al usuario para que mire el log
        echo "Node: $TARGET5 - $(date +%F\ %T) - Failed - Check status of the node $TARGET5!" >> $LOG
        echo "Error in the connection of node $TARGET5, check "ConnectionResults.log" for more details"
fi
if ping -n -c 4 $TARGET6 >/dev/null #Ping de 4 paquetes
    then
        #Hay conexion, se guarda en el log el mensaje
        echo "Node: $TARGET6 - $(date +%F\ %T) - Successful" >> $LOG
    else
        #No hay conexion y mostramos el aviso al usuario para que mire el log
        echo "Node: $TARGET6 (Google) - $(date +%F\ %T) - Failed - Check status of the internet connection!" >> $LOG
        echo "Error in the connection of node $TARGET6, check "ConnectionResults.log" for more details"
fi
echo " " >>$LOG
