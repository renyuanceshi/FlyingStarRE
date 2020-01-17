package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Barcode implements SafeParcelable {
    public static final int ALL_FORMATS = 0;
    public static final int AZTEC = 4096;
    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final zzb CREATOR = new zzb();
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    public CalendarEvent calendarEvent;
    public ContactInfo contactInfo;
    public Point[] cornerPoints;
    public String displayValue;
    public DriverLicense driverLicense;
    public Email email;
    public int format;
    public GeoPoint geoPoint;
    public Phone phone;
    public String rawValue;
    public Sms sms;
    public UrlBookmark url;
    public int valueFormat;
    final int versionCode;
    public WiFi wifi;

    public static class Address implements SafeParcelable {
        public static final zza CREATOR = new zza();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String[] addressLines;
        public int type;
        final int versionCode;

        public Address() {
            this.versionCode = 1;
        }

        public Address(int i, int i2, String[] strArr) {
            this.versionCode = i;
            this.type = i2;
            this.addressLines = strArr;
        }

        public int describeContents() {
            zza zza = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zza zza = CREATOR;
            zza.zza(this, parcel, i);
        }
    }

    public static class CalendarDateTime implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        public int day;
        public int hours;
        public boolean isUtc;
        public int minutes;
        public int month;
        public String rawValue;
        public int seconds;
        final int versionCode;
        public int year;

        public CalendarDateTime() {
            this.versionCode = 1;
        }

        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, String str) {
            this.versionCode = i;
            this.year = i2;
            this.month = i3;
            this.day = i4;
            this.hours = i5;
            this.minutes = i6;
            this.seconds = i7;
            this.isUtc = z;
            this.rawValue = str;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc zzc = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    public static class CalendarEvent implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        public String description;
        public CalendarDateTime end;
        public String location;
        public String organizer;
        public CalendarDateTime start;
        public String status;
        public String summary;
        final int versionCode;

        public CalendarEvent() {
            this.versionCode = 1;
        }

        public CalendarEvent(int i, String str, String str2, String str3, String str4, String str5, CalendarDateTime calendarDateTime, CalendarDateTime calendarDateTime2) {
            this.versionCode = i;
            this.summary = str;
            this.description = str2;
            this.location = str3;
            this.organizer = str4;
            this.status = str5;
            this.start = calendarDateTime;
            this.end = calendarDateTime2;
        }

        public int describeContents() {
            zzd zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd zzd = CREATOR;
            zzd.zza(this, parcel, i);
        }
    }

    public static class ContactInfo implements SafeParcelable {
        public static final zze CREATOR = new zze();
        public Address[] addresses;
        public Email[] emails;
        public PersonName name;
        public String organization;
        public Phone[] phones;
        public String title;
        public String[] urls;
        final int versionCode;

        public ContactInfo() {
            this.versionCode = 1;
        }

        public ContactInfo(int i, PersonName personName, String str, String str2, Phone[] phoneArr, Email[] emailArr, String[] strArr, Address[] addressArr) {
            this.versionCode = i;
            this.name = personName;
            this.organization = str;
            this.title = str2;
            this.phones = phoneArr;
            this.emails = emailArr;
            this.urls = strArr;
            this.addresses = addressArr;
        }

        public int describeContents() {
            zze zze = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zze zze = CREATOR;
            zze.zza(this, parcel, i);
        }
    }

    public static class DriverLicense implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        public String addressCity;
        public String addressState;
        public String addressStreet;
        public String addressZip;
        public String birthDate;
        public String documentType;
        public String expiryDate;
        public String firstName;
        public String gender;
        public String issueDate;
        public String issuingCountry;
        public String lastName;
        public String licenseNumber;
        public String middleName;
        final int versionCode;

        public DriverLicense() {
            this.versionCode = 1;
        }

        public DriverLicense(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.versionCode = i;
            this.documentType = str;
            this.firstName = str2;
            this.middleName = str3;
            this.lastName = str4;
            this.gender = str5;
            this.addressStreet = str6;
            this.addressCity = str7;
            this.addressState = str8;
            this.addressZip = str9;
            this.licenseNumber = str10;
            this.issueDate = str11;
            this.expiryDate = str12;
            this.birthDate = str13;
            this.issuingCountry = str14;
        }

        public int describeContents() {
            zzf zzf = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzf zzf = CREATOR;
            zzf.zza(this, parcel, i);
        }
    }

    public static class Email implements SafeParcelable {
        public static final zzg CREATOR = new zzg();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String address;
        public String body;
        public String subject;
        public int type;
        final int versionCode;

        public Email() {
            this.versionCode = 1;
        }

        public Email(int i, int i2, String str, String str2, String str3) {
            this.versionCode = i;
            this.type = i2;
            this.address = str;
            this.subject = str2;
            this.body = str3;
        }

        public int describeContents() {
            zzg zzg = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzg zzg = CREATOR;
            zzg.zza(this, parcel, i);
        }
    }

    public static class GeoPoint implements SafeParcelable {
        public static final zzh CREATOR = new zzh();
        public double lat;
        public double lng;
        final int versionCode;

        public GeoPoint() {
            this.versionCode = 1;
        }

        public GeoPoint(int i, double d, double d2) {
            this.versionCode = i;
            this.lat = d;
            this.lng = d2;
        }

        public int describeContents() {
            zzh zzh = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzh zzh = CREATOR;
            zzh.zza(this, parcel, i);
        }
    }

    public static class PersonName implements SafeParcelable {
        public static final zzi CREATOR = new zzi();
        public String first;
        public String formattedName;
        public String last;
        public String middle;
        public String prefix;
        public String pronunciation;
        public String suffix;
        final int versionCode;

        public PersonName() {
            this.versionCode = 1;
        }

        public PersonName(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.versionCode = i;
            this.formattedName = str;
            this.pronunciation = str2;
            this.prefix = str3;
            this.first = str4;
            this.middle = str5;
            this.last = str6;
            this.suffix = str7;
        }

        public int describeContents() {
            zzi zzi = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzi zzi = CREATOR;
            zzi.zza(this, parcel, i);
        }
    }

    public static class Phone implements SafeParcelable {
        public static final zzj CREATOR = new zzj();
        public static final int FAX = 3;
        public static final int HOME = 2;
        public static final int MOBILE = 4;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String number;
        public int type;
        final int versionCode;

        public Phone() {
            this.versionCode = 1;
        }

        public Phone(int i, int i2, String str) {
            this.versionCode = i;
            this.type = i2;
            this.number = str;
        }

        public int describeContents() {
            zzj zzj = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzj zzj = CREATOR;
            zzj.zza(this, parcel, i);
        }
    }

    public static class Sms implements SafeParcelable {
        public static final zzk CREATOR = new zzk();
        public String message;
        public String phoneNumber;
        final int versionCode;

        public Sms() {
            this.versionCode = 1;
        }

        public Sms(int i, String str, String str2) {
            this.versionCode = i;
            this.message = str;
            this.phoneNumber = str2;
        }

        public int describeContents() {
            zzk zzk = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzk zzk = CREATOR;
            zzk.zza(this, parcel, i);
        }
    }

    public static class UrlBookmark implements SafeParcelable {
        public static final zzl CREATOR = new zzl();
        public String title;
        public String url;
        final int versionCode;

        public UrlBookmark() {
            this.versionCode = 1;
        }

        public UrlBookmark(int i, String str, String str2) {
            this.versionCode = i;
            this.title = str;
            this.url = str2;
        }

        public int describeContents() {
            zzl zzl = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzl zzl = CREATOR;
            zzl.zza(this, parcel, i);
        }
    }

    public static class WiFi implements SafeParcelable {
        public static final zzm CREATOR = new zzm();
        public static final int OPEN = 1;
        public static final int WEP = 3;
        public static final int WPA = 2;
        public int encryptionType;
        public String password;
        public String ssid;
        final int versionCode;

        public WiFi() {
            this.versionCode = 1;
        }

        public WiFi(int i, String str, String str2, int i2) {
            this.versionCode = i;
            this.ssid = str;
            this.password = str2;
            this.encryptionType = i2;
        }

        public int describeContents() {
            zzm zzm = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzm zzm = CREATOR;
            zzm.zza(this, parcel, i);
        }
    }

    public Barcode() {
        this.versionCode = 1;
    }

    public Barcode(int i, int i2, String str, String str2, int i3, Point[] pointArr, Email email2, Phone phone2, Sms sms2, WiFi wiFi, UrlBookmark urlBookmark, GeoPoint geoPoint2, CalendarEvent calendarEvent2, ContactInfo contactInfo2, DriverLicense driverLicense2) {
        this.versionCode = i;
        this.format = i2;
        this.rawValue = str;
        this.displayValue = str2;
        this.valueFormat = i3;
        this.cornerPoints = pointArr;
        this.email = email2;
        this.phone = phone2;
        this.sms = sms2;
        this.wifi = wiFi;
        this.url = urlBookmark;
        this.geoPoint = geoPoint2;
        this.calendarEvent = calendarEvent2;
        this.contactInfo = contactInfo2;
        this.driverLicense = driverLicense2;
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public Rect getBoundingBox() {
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Point point : this.cornerPoints) {
            i = Math.min(i, point.x);
            int max = Math.max(i2, point.x);
            i4 = Math.min(i4, point.y);
            i3 = Math.max(i3, point.y);
            i2 = max;
        }
        return new Rect(i, i4, i2, i3);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }
}
