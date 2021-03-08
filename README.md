# Fit-Friends
an Android Gym Managment System 

## intro
Fit Friends is an android gym management system to help gym managers to work easier and more productive.

## Developer's Part
if you want check and develop the source code 

- **step 1**: install Android Studio in your Computer
- **step 2**: install Git
- **step 3**: clone the repository.

```bash
$ git clone https://github.com/eqba1/Fit-Friends.git
```

- **step 4**: open the Android Studio and find the directory of project.
- **step 5**: open the Project.
- **step 5**: run ,enjoy!

**issue**: CRASH Application in Initaial Running

**fix**: comment out AppDatabase `onCreate()` method body.
```kotlin
    override fun onCreate(sqLite: SQLiteDatabase?) {
        /* add this line
        // creates account table if not exist
        // executes SQL commands
        // we put "!!" because sqLite it's nullable
        sqLite!!.execSQL("CREATE TABLE IF NOT EXISTS $ACCOUNT_TABLE (" +
                "$ACCOUNT_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$ACCOUNT_USERNAME VARCHAR(20) NOT NULL, " +
                "$ACCOUNT_PASSWORD TEXT NOT NULL, " +
                "$ACCOUNT_REGISTER_DATE VARCHAR(10))")
         .
         .
         .
                "FOREIGN KEY($TRAINER_ACCOUNT_ID) REFERENCES $ACCOUNT_TABLE($ACCOUNT_ID), " +
                "FOREIGN KEY($TRAINER_PERSON_ID) REFERENCES $PERSON_TABLE($PERSON_ID))")
         */// end comment
    }
             
```
feel free of Developing and Contributing

## User's Part

download apk file from website and enjoy it :)

## Licence
Copyright (c) 2021



