package ca.cois2240group20.grocerymanagementapp.utility;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null: new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }
}
<<<<<<< HEAD

=======
>>>>>>> 2c84a427757f680022f6749e9a0644357a3212b2
