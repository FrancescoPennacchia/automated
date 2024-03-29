# Progetto Principale

Questo è il progetto principale per l'esame di Automated Software Delivery

## Obiettivi

- Configurare un sistema di build automatico per garantire la coerenza e l'efficienza del processo di sviluppo.
- Utilizzare Git come sistema di controllo della versione e collegarlo a un repository remoto per la gestione centralizzata del codice.
- Creare una pipeline di Continuous Integration per automatizzare il processo di test e di analisi del codice.
- Sviluppare un Dockerfile per definire l'ambiente di esecuzione del progetto e un docker-compose per la gestione dei container.

## Descrizione
back-end Spring Boot, con JWT e Spring Security.

Tecnologie utilizzate:
- Maven
- Checkstyle
- Spotbugs
- docker - docker-compose
- GitHub Actions


## Comandi
Comandi senza l'utilizzo di docker:
- docker run --name postgresql -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -p 5432:5432  -d postgres
- Run ApplicationMain

Per utilizzare docker:
- mvn package -DskipTests                        #Bisogna avere maven installato
- docker-compose up                              #Bisogna avere docker e docker-compose

Per Kubernetes (Disponibile solo sul branch kubernetes):
- Realizzato tramite l'utilizzo di minikube. Necessita l'installazione di minikube e kubernetes.
- minikube start
- kubectl apply --filename ./kubernetes/database-kubernetes.yaml
- kubectl apply --filename ./kubernetes/automated-kubernetes.yaml
- minikube service --all

# Realizzato da:

Francesco Pennacchia

