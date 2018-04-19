#!/bin/bash
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v0.2 alpha

By UDA Corp. under MIT license
"
#Indicamos cual sera el fichero log y le añadimos cabecera
LOG="ConnectionResults.log"
echo "
▒█▄░▒█ █▀▀ ▀▀█▀▀ █░░░█ █▀▀█ █▀▀█ █░█ 　 █▀▀ █░░█ █▀▀ █▀▀ █░█ █▀▀ █▀▀█
▒█▒█▒█ █▀▀ ░░█░░ █▄█▄█ █░░█ █▄▄▀ █▀▄ 　 █░░ █▀▀█ █▀▀ █░░ █▀▄ █▀▀ █▄▄▀
▒█░░▀█ ▀▀▀ ░░▀░░ ░▀░▀░ ▀▀▀▀ ▀░▀▀ ▀░▀ 　 ▀▀▀ ▀░░▀ ▀▀▀ ▀▀▀ ▀░▀ ▀▀▀ ▀░▀▀ v0.2 alpha

Result(s) of the test(s)
" >> $LOG
#While para introducir cuantos nodos se quiera comprobar
####RESPUESTA="S"
####while $RESPUESTA -eq "S"
####    do
        #Nodo para hacer ping introducirdo por el usuario
        echo "Por favor, introduzca la direccion del nodo a comprobar (Ejemplo: "8.8.8.8")"
        read TARGET
        #Comunicamos al usuario que espere
        echo "Realizando "test" de red, espere por favor..."
        #Hacemos el ping e indicamos si ha habido conexion o no
        if ping -n -c 4 $TARGET >/dev/null #Ping de 4 paquetes
            then
                #Hay conexion
                echo "Node: $TARGET - $(date +%F\ %T) - Successful" >> $LOG
            else
                #No hay conexion
                echo "Node: $TARGET - $(date +%F\ %T) - Failed" >> $LOG
        fi
        #Preguntamos al usuario si desea realizar mas tests
        read -p "Test realizado, ¿desea realizar la comprobacion a otro nodo? (S/N): " RESPUESTA
####done
#Indicamos al usuario que los resultados ya estan disponibles y se los mostramos
echo ""
echo "Los resultados estan guardados en el fichero "ConnectionResults.log""
sleep 1;
echo "Mostrando resultados..."
#Dejamos 2 segundos para que vea el mensaje antes de utilizar el terminal de nuevo
sleep 2;
cat ConnectionResults.log

##Estructura de error (no conexion)
##Node: nodo - 2018-04-19 11:02:34 - Failed

##Estructura de conexion satisfactoria
##Node: nodo - 2018-04-19 11:02:34 - Successful
