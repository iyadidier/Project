/** * Full Name: didier iyamuremye*
 * Student ID:041104829 *
 * Course: CST3104 *
 * Term: Fall 2024 *
 * Assignment: Team Project *
 * Date : 21/11/24*/
package com.cst3104.project.marvel;

import androidx.room.TypeConverter;
import java.util.Date;

public class Converters {

    // Convert Date to Long (timestamp)
    @TypeConverter
    public static Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }

    // Convert Long (timestamp) to Date
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }
}
