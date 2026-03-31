/*
 Booking.java
 Booking Entity 
 Author: AJ Mitchell 219024979
 Date: 9 June
 */

package za.ac.cput.ADP3LabBookingSystem.Entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name = "Booking")
public class Booking{
    //instance vars
    @Id
    private String bookingid;
    private String studentnr;
    private Date bookingdate;
    private String starttime;
    private String endtime;
    private String labid;
    private String seatnumber;

    //Private default constructor
    protected Booking(){}
    //Private constructor that accepts a Builder object
    private Booking(Builder builder){
        this.bookingid = builder.bookingid;
        this.studentnr = builder.studentnr;
        this.bookingdate = builder.bookingdate;
        this.starttime = builder.starttime;
        this.endtime = builder.endtime;
        this.labid = builder.labid;
        this.seatnumber = builder.seatnumber;
    }

    //Getters and toString methods
    public String getBookingId(){
        return bookingid;
    }

    public String getStudentnr(){ return studentnr; }

    public Date getBookingDate(){ return bookingdate; }

    public String getBookingStartTime(){ return starttime; }

    public String getBookingEndTime(){ return endtime; }

    public String getBookingLabId(){ return labid; }

    public String getBookingSeatNumber(){ return seatnumber; }

    public String toString(){
        return "Booking{" +
                " bookingid = " + this.bookingid +
                ", studentnr = " + this.studentnr +
                ", bookingdate = " + this.bookingdate +
                ", starttime = " + this.starttime +
                ", endtime = "+ this.endtime +
                ", labid = " + this.labid +
                ", seatnumber = " + this.seatnumber +
                '}';
    }


    public static class Builder{

        private String bookingid;
        private String studentnr;
        private Date bookingdate;
        private String starttime;
        private String endtime;
        private String labid;
        private String seatnumber;



        public static Builder newInstance(){
            return new Builder();
        }

        //Setters
        public Builder setBookingId(String bookingid) {
            this.bookingid = bookingid;
            return this;
        }

        public Builder setStudentNr(String studentnr) {
            this.studentnr = studentnr;
            return this;
        }

        public Builder setBookingDate(Date bookingdate) {
            this.bookingdate = bookingdate;
            return this;
        }

        public Builder setStartTime(String starttime) {
            this.starttime = starttime;
            return this;
        }

        public Builder setEndTime(String endtime) {
            this.endtime = endtime;
            return this;
        }

        public Builder setLabId(String labid) {
            this.labid = labid;
            return this;
        }

        public Builder setSeatNumber(String seatnumber) {
            this.seatnumber = seatnumber;
            return this;
        }

        public Builder copy(Booking booking){
            this.bookingid = booking.bookingid;
            this.studentnr = booking.studentnr;
            this.bookingdate = booking.bookingdate;
            this.starttime = booking.starttime;
            this.endtime = booking.endtime;
            this.labid = booking.labid;
            this.seatnumber = booking.seatnumber;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }

    }//end Builder class

}