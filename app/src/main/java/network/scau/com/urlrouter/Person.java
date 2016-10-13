package network.scau.com.urlrouter;

import android.os.Parcel;
import android.os.Parcelable;

import com.scau.UrlBinding;

/**
 * Created by Administrator on 2016/9/10 0010.
 */
public class Person implements Parcelable {


    private String name;

    private int age;

    public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel parcel) {
            Person p = new Person();
            p.name = parcel.readString();
            p.age = parcel.readInt();
            return p;
        }

        @Override
        public Person[] newArray(int i) {
            return new Person[i];
        }
    };



    @Override

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
