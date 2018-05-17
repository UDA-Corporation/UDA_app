Estructura del fichero de log
====
Nuestro planteamiento es ejecutar un ping, creado en un script bash, ejecutado en el servidor que realice un ping a cada nodo de la red (todos los contenedores que hay en proxmox), enviando 4 paquetes, y, que se ejecute cada medio minuto. En caso de que todos los nodos tengan conexión, se generará un fichero que indique que la conexión ha sido correcta, fecha, número de nodo y hora. Se irá añadiendo cada ping exitoso al fichero log, en bloques de 5 (existen 5 nodos, 5 contenedores). Para llevar un historial.  
En cuanto haya un error de conexión en uno de los nodos, se mostrará inmediatamente en la terminal un mensaje que indica el nodo que da problemas, a la vez que otro pidiendo al usuario que mire el fichero “log” para más detalles.  
Es decir, el fichero log contendrá un historial de los pings exitosos y fallidos, pero solo notificará al usuario cuando encuentre un problema con uno de los nodos. La estructura del fichero “log” será así:  
>#Estructura de error (no respuesta)    
>Nodo: $node - 2018-04-19 11:02:34 - Failed - Check status of the node $node!  
>#La consola avisará al usuario de la siguiente forma  
>Error in the connection of node $node, check "ConnectionResults.log" for more details  
>#Estructura de conexion satisfactoria  
>Nodo: $node - 2018-04-19 11:02:34 - Successful  
