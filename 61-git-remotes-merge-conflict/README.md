# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git

crea con successo il clone repository nella mia cartella

2. Ci si assicuri di avere localmente entrambi i branch remoti
git remote show origin

head branch = master
remote branches:
feature tracked; master tracked

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
avendo verificato di essere gia sul master posso effettuare il merge

git merge origin/feature

Merge conflict in helloworld.java

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
git remote set-url origin https://github.com/GiangiPoli/RepoEsercizio61.git
in questo modo ho i permessi di scrittura dentro il repository

8. Si faccia push del branch `master` sul proprio repository
ho cambiato il https, con shh (in quanto ho creato e impostato la chiave)
git remote set-url origin git@github.com:GiangiPoli/RepoEsercizio61.git

a questo punto ho fatto la push che è andata a buon fine
git push origin

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

git branch --set-upstream-to master

git push

tutto è stato aggiornato 
