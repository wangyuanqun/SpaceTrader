You can `gradle build` first.

But you must use following commands to run this app.

## `gradle run --args="offline"` is for offline version.

## `gradle run --args="online"` is for online version.



- ==The user can see whether the server is currently active==

  when you open the window it is displayed on the main window.



- ==A new user can obtain and store credentials (these can just be stored in RAM, no need for saving to disk)==

  if you choose to sign up, then after you choose your username, you can either save or close the window.

  - if you choose to save, there is an information to show you that you save successfully, then you can login without typing anything.
  - if you choose to close the window, then you need to type in the username and token.



- ==An existing user can enter and store their existing credentials==

  if you already have an account, then after you login, the username and token automatically saved for this time.



- ==The user can see their info==

  After you login, your info is in `User Info` tab.



- ==The user can list available loans and their details==

  These are listed in `Loan` tab.



- ==The user can obtain a loan==

  this can be done in `Loan` tab.



- ==The user can list active loans==

  this is listed in `Loan` tab.



- ==The user can pay off a loan==

  this can be done in `Loan` tab.



- ==The user can list available ships and their details==

  these are listed in `Ships` tab.



- ==The user can purchase a ship==

  this can be done in `Ships` tab.



- ==The user can list their ships and their details==

  This is listed in `User Info` tab.



- ==The user can purchase ship fuel==

  This can be done in `Market` tab, the good you can buy is in "Market place" in `Location` tab.



- ==The user can view the marketplace details for a given location==

  This can be in `Location` tab.



- ==The user can purchase goods from the marketplace==

  This can be done in `Market` tab, the good you can buy is in "Market place" in `Location` tab.



- ==The user can list nearby locations and their details==

  This can be done in `Location` tab.



- ==The user can create a flight plan and journey to a nearby location==

  This can be done in `Flight Plan` tab.



- ==The user can view their current flight plan (this does not need to automatically refresh, manual is ok)==

  This can be done in `Flight Plan`  tab.



- ==The user can sell goods to the marketplace==

  This can be done in `Market` tab.