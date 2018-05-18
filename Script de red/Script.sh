#!/bin/bash
#To repeat the script automatically every 10 minutes---> crontab -e (to open crontab) and put "*/10 * * * * /root/Script/Script.sh" in the file. Save.
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v1.2

By UDA Corp. under MIT license
"
#Indicamos cual sera el fichero log y le anadimos cabecera
LOG="ConnectionResults.log"
#Variable para borrar el log (todo conectado de nuevo)
VAR=0

#Nodos para hacer ping
TARGET="10.1.1.1"
TARGET2="10.1.2.1"
TARGET3="10.1.3.1"
TARGET4="10.1.11.1"
TARGET5="10.1.10.1"
TARGET6="8.8.8.8"

#Hacemos el ping e indicamos si hay problemas en la conexion. Si la conexion funciona, elimina el fichero log.
if ping -n -c 4 $TARGET >/dev/null #Ping de 4 paquetes
    then
        VAR=`expr $VAR + 1`
    else
        #No hay conexion, creamos el archivo log
        echo "
        Result(s) of the test(s)
        " >> $LOG
        echo "Node: $TARGET - $(date +%F\ %T) - Failed - Check status of the node $TARGET!" >> $LOG
fi
if ping -n -c 4 $TARGET2 >/dev/null #Ping de 4 paquetes
    then
        VAR=`expr $VAR + 1`
    else
        #No hay conexion, creamos el archivo log
        echo "
        Result(s) of the test(s)
        " >> $LOG
        echo "Node: $TARGET2 - $(date +%F\ %T) - Failed - Check status of the node $TARGET2!" >> $LOG
fi
if ping -n -c 4 $TARGET3 >/dev/null #Ping de 4 paquetes
    then
        VAR=`expr $VAR + 1`
    else
        #No hay conexion, creamos el archivo log
        echo "
        Result(s) of the test(s)
        " >> $LOG
        echo "Node: $TARGET3 - $(date +%F\ %T) - Failed - Check status of the node $TARGET3!" >> $LOG
fi
if ping -n -c 4 $TARGET4 >/dev/null #Ping de 4 paquetes
    then
        VAR=`expr $VAR + 1`
    else
        #No hay conexion, creamos el archivo log
        echo "
        Result(s) of the test(s)
        " >> $LOG
        echo "Node: $TARGET4 - $(date +%F\ %T) - Failed - Check status of the node $TARGET4!" >> $LOG
fi
if ping -n -c 4 $TARGET5 >/dev/null #Ping de 4 paquetes
    then
        VAR=`expr $VAR + 1`
    else
        #No hay conexion, creamos el archivo log
        echo "
        Result(s) of the test(s)
        " >> $LOG
        echo "Node: $TARGET5 - $(date +%F\ %T) - Failed - Check status of the node $TARGET5!" >> $LOG
fi
if ping -n -c 4 $TARGET6 >/dev/null #Ping de 4 paquetes
    then
        VAR=`expr $VAR + 1`
    else
        #No hay conexion, creamos el archivo log
        echo "
        Result(s) of the test(s)
        " >> $LOG
        echo "Node: $TARGET6 (Google)- $(date +%F\ %T) - Failed - Check status of the internet connection!" >> $LOG
fi
if [ "$VAR" -eq 6 ]
    then
        rm ConnectionResults.log
fi
