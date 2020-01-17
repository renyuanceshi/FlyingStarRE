package m.e.huyen2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {
    Object[] a = new Object[24];
    TextView a1;
    TextView a10;
    TextView a11;
    TextView a12;
    TextView a13;
    TextView a14;
    TextView a15;
    TextView a16;
    TextView a17;
    TextView a18;
    TextView a2;
    TextView a3;
    TextView a4;
    TextView a5;
    TextView a6;
    TextView a7;
    TextView a8;
    TextView a9;
    Object[] ab = new Object[24];
    private ArrayAdapter<String> adap2;
    private ArrayAdapter<String> adap3;
    private ArrayAdapter<String> adap4;
    private ArrayAdapter<String> adap5;
    private ArrayAdapter<String> adapter;
    Object[] ax = new Object[24];
    Object[] ax2 = new Object[24];
    TextView b1;
    TextView b2;
    TextView b3;
    TextView b4;
    TextView b5;
    TextView b6;
    TextView b7;
    TextView b8;
    TextView b9;
    Button bb1;
    Button bb2;
    Button bb3;
    Button bb4;
    TextView c1;
    TextView c2;
    TextView c3;
    TextView c4;
    TextView c5;
    TextView c6;
    TextView c7;
    TextView c8;
    TextView c9;
    String co = "Show";
    TextView d1;
    TextView d2;
    TextView d3;
    TextView d4;
    TextView d5;
    TextView d6;
    TextView d7;
    TextView d8;
    TextView d9;
    String[] data = {"4(1924-1943)", "5(1944-1963)", "6(1964-1983)", "7(1984-2003)", "8(2004-2023)", "9(2024-2043)", "1(2044-2063)", "2(2064-2083)", "3(2084-2103)"};
    String[] data2 = {"357-3", "4-7.5", "7.5-11", "12-18", "19-22.5", "22.5-26", "27-33", "34-37.5", "37.5-41", "42-48", "49-52.5", "52.5-56", "57-63", "64-67.5", "67.5-71", "72-78", "79-82.5", "82.5-86", "87-93", "94-97.5", "97.5-101", "102-108", "109-112.5", "112.5-116", "117-123", "124-127.5", "127.5-131", "132-138", "139-142.5", "142.5-146", "147-153", "154-157.5", "157.5-161", "162-168", "169-172.5", "172.5-176", "177-183", "184-187.5", "187.5-191", "192-198", "199-202.5", "202.5-206", "207-213", "214-217.5", "217.5-221", "222-228", "229-232.5", "232.5-236", "237-243", "244-247.5", "247.5-251", "252-258", "259-262.5", "262.5-266", "267-273", "274-277.5", "277.5-281", "282-288", "289-292.5", "292.5-296", "297-303", "304-307.5", "307.5-311", "312-318", "319-322.5", "322.5-326", "327-333", "334-337.5", "337.5-341", "342-348", "349-352.5", "352.5-356"};
    String[] data3 = {"1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
    String[] data4 = {"Show", "Not show"};
    private String[] data44 = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] data5 = {"Yin", "Mao", "Chen", "Si", "Wu", "Wei", "Shen", "You", "Xu", "Hai", "Zi", "Chou"};
    TextView dos;
    String doso;
    String[] hhuong = {"Zi", "Gui", "Chou", "Gen", "Yin", "Jia", "Mao", "Yi", "Chen", "Xun", "Si", "Bing", "Wu", "Ding", "Wei", "Kun", "Shen", "Geng", "You", "Xin", "Xu", "Qian", "Hai", "Ren"};
    int[] k = {5, 6, 6, 7, 7, 7, 7, 9, 9, 1, 1, 2, 2, 2, 2, 6, 6, 5};
    int[] k10 = {2, 9, 2, 1, 6, 2, 5, 2, 6, 6, 7, 5, 7, 6, 9, 7, 1, 7};
    int[] k11 = {1, 9, 2, 1, 6, 1, 5, 2, 6, 6, 7, 5, 9, 6, 9, 7, 1, 9};
    int[] k12 = {6, 5, 9, 6, 7, 9, 7, 7, 2, 7, 2, 2, 1, 2, 6, 1, 5, 6};
    int[] k13 = {6, 5, 7, 6, 7, 7, 9, 7, 1, 9, 2, 1, 2, 2, 6, 2, 5, 6};
    int[] k14 = {6, 5, 7, 6, 9, 7, 9, 9, 1, 9, 1, 1, 2, 1, 6, 2, 5, 6};
    int[] k15 = {6, 9, 5, 7, 6, 7, 9, 2, 7, 2, 7, 1, 2, 6, 2, 5, 1, 6};
    int[] k16 = {6, 7, 5, 8, 6, 9, 7, 1, 7, 2, 9, 2, 1, 6, 2, 5, 2, 6};
    int[] k17 = {6, 7, 5, 9, 6, 9, 7, 1, 9, 1, 9, 2, 1, 6, 1, 5, 2, 6};
    int[] k18 = {7, 1, 7, 6, 2, 5, 2, 6, 1, 9, 6, 7, 5, 7, 6, 2, 9, 2};
    int[] k19 = {7, 2, 9, 6, 1, 5, 2, 6, 2, 7, 6, 7, 5, 9, 6, 1, 7, 2};
    int[] k2 = {5, 6, 6, 7, 7, 9, 9, 9, 9, 1, 1, 1, 1, 2, 2, 6, 6, 5};
    int[] k20 = {9, 2, 9, 6, 1, 5, 1, 6, 2, 7, 6, 9, 5, 9, 6, 1, 7, 1};
    int[] k21 = {7, 2, 2, 1, 2, 6, 1, 5, 6, 6, 5, 9, 6, 7, 9, 7, 7, 2};
    int[] k22 = {9, 2, 1, 2, 2, 6, 2, 5, 6, 6, 5, 7, 6, 7, 7, 9, 8, 1};
    int[] k23 = {9, 1, 1, 2, 1, 6, 2, 5, 6, 6, 5, 7, 6, 9, 7, 9, 9, 1};
    int[] k24 = {5, 6, 6, 9, 9, 7, 7, 7, 7, 2, 2, 2, 2, 1, 1, 6, 6, 5};
    int[] k3 = {9, 6, 7, 5, 7, 6, 2, 9, 2, 7, 1, 7, 6, 2, 5, 2, 6, 1};
    int[] k4 = {7, 6, 7, 5, 9, 6, 1, 7, 2, 8, 2, 9, 6, 1, 5, 2, 6, 2};
    int[] k5 = {7, 6, 9, 5, 9, 6, 1, 7, 1, 9, 2, 9, 6, 1, 5, 1, 6, 2};
    int[] k6 = {1, 7, 6, 7, 5, 2, 6, 2, 9, 1, 7, 6, 7, 5, 2, 6, 2, 9};
    int[] k7 = {2, 7, 6, 9, 5, 1, 6, 2, 7, 2, 7, 6, 9, 5, 1, 6, 2, 7};
    int[] k8 = {2, 9, 6, 9, 5, 1, 6, 1, 7, 2, 9, 6, 9, 5, 1, 6, 1, 7};
    int[] k9 = {2, 7, 1, 2, 6, 2, 5, 1, 6, 6, 9, 5, 7, 6, 7, 9, 2, 7};
    int[] ka = {2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2};
    int[] ka10 = {1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1};
    int[] ka11 = {1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1};
    int[] ka12 = {2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2};
    int[] ka13 = {1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1};
    int[] ka14 = {1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1};
    int[] ka15 = {2, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 2};
    int[] ka16 = {1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1};
    int[] ka17 = {1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1};
    int[] ka18 = {2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2};
    int[] ka19 = {1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1};
    int[] ka2 = {2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2};
    int[] ka20 = {1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1};
    int[] ka21 = {1, 2, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1};
    int[] ka22 = {2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 2};
    int[] ka23 = {2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 2};
    int[] ka24 = {1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1};
    int[] ka3 = {1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 2, 2, 2, 1};
    int[] ka4 = {2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2};
    int[] ka5 = {2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2};
    int[] ka6 = {1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1};
    int[] ka7 = {2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2};
    int[] ka8 = {2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2};
    int[] ka9 = {2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 1, 1, 2};
    String luu = "2016";
    int[] ma = {5, 6, 6, 7, 7, 8, 8, 9, 9, 1, 1, 2, 2, 3, 3, 4, 4, 5};
    int[] ma10 = {2, 9, 3, 1, 4, 2, 5, 3, 6, 4, 7, 5, 8, 6, 9, 7, 1, 8};
    int[] ma11 = {2, 9, 3, 1, 4, 2, 5, 3, 6, 4, 7, 5, 8, 6, 9, 7, 1, 8};
    int[] ma12 = {6, 5, 7, 6, 8, 7, 9, 8, 1, 9, 2, 1, 3, 2, 4, 3, 5, 4};
    int[] ma13 = {6, 5, 7, 6, 8, 7, 9, 8, 1, 9, 2, 1, 3, 2, 4, 3, 5, 4};
    int[] ma14 = {6, 5, 7, 6, 8, 7, 9, 8, 1, 9, 2, 1, 3, 2, 4, 3, 5, 4};
    int[] ma15 = {4, 7, 5, 8, 6, 9, 7, 1, 8, 2, 9, 3, 1, 4, 2, 5, 3, 6};
    int[] ma16 = {4, 7, 5, 8, 6, 9, 7, 1, 8, 2, 9, 3, 1, 4, 2, 5, 3, 6};
    int[] ma17 = {4, 7, 5, 8, 6, 9, 7, 1, 8, 2, 9, 3, 1, 4, 2, 5, 3, 6};
    int[] ma18 = {8, 3, 9, 4, 1, 5, 2, 6, 3, 7, 4, 8, 5, 9, 6, 1, 7, 2};
    int[] ma19 = {8, 3, 9, 4, 1, 5, 2, 6, 3, 7, 4, 8, 5, 9, 6, 1, 7, 2};
    int[] ma2 = {5, 6, 6, 7, 7, 8, 8, 9, 9, 1, 1, 2, 2, 3, 3, 4, 4, 5};
    int[] ma20 = {8, 3, 9, 4, 1, 5, 2, 6, 3, 7, 4, 8, 5, 9, 6, 1, 7, 2};
    int[] ma21 = {9, 2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 6, 8, 7, 9, 8, 1};
    int[] ma22 = {9, 2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 6, 8, 7, 9, 8, 1};
    int[] ma23 = {9, 2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 6, 8, 7, 9, 8, 1};
    int[] ma24 = {5, 6, 6, 7, 7, 8, 8, 9, 9, 1, 1, 2, 2, 3, 3, 4, 4, 5};
    int[] ma3 = {7, 4, 8, 5, 9, 6, 1, 7, 2, 8, 3, 9, 4, 1, 5, 2, 6, 3};
    int[] ma4 = {7, 4, 8, 5, 9, 6, 1, 7, 2, 8, 3, 9, 4, 1, 5, 2, 6, 3};
    int[] ma5 = {7, 4, 8, 5, 9, 6, 1, 7, 2, 8, 3, 9, 4, 1, 5, 2, 6, 3};
    int[] ma6 = {3, 8, 4, 9, 5, 1, 6, 2, 7, 3, 8, 4, 9, 5, 1, 6, 2, 7};
    int[] ma7 = {3, 8, 4, 9, 5, 1, 6, 2, 7, 3, 8, 4, 9, 5, 1, 6, 2, 7};
    int[] ma8 = {3, 8, 4, 9, 5, 1, 6, 2, 7, 3, 8, 4, 9, 5, 1, 6, 2, 7};
    int[] ma9 = {2, 9, 3, 1, 4, 2, 5, 3, 6, 4, 7, 5, 8, 6, 9, 7, 1, 8};
    int[] madem = new int[54];
    int[] man = {2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2};
    int[] man10 = {1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1};
    int[] man11 = {1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1};
    int[] man12 = {2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2};
    int[] man13 = {1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1};
    int[] man14 = {1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1};
    int[] man15 = {2, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 2};
    int[] man16 = {1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1};
    int[] man17 = {1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1};
    int[] man18 = {2, 1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 1, 1, 2};
    int[] man19 = {1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1};
    int[] man2 = {2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2};
    int[] man20 = {1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1};
    int[] man21 = {1, 2, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 2, 1};
    int[] man22 = {2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 2};
    int[] man23 = {2, 1, 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 2};
    int[] man24 = {1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1};
    int[] man3 = {1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 1, 2, 2, 2, 1};
    int[] man4 = {2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2};
    int[] man5 = {2, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 1, 1, 1, 2};
    int[] man6 = {1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1};
    int[] man7 = {2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2};
    int[] man8 = {2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2};
    int[] man9 = {2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 1, 1, 2};
    int[] maset = new int[18];
    /* access modifiers changed from: private */
    public ImageView mui2;
    int[] saol = {7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int sonam = 2016;
    /* access modifiers changed from: private */
    public Spinner sp;
    /* access modifiers changed from: private */
    public Spinner sp2;
    /* access modifiers changed from: private */
    public Spinner sp3;
    /* access modifiers changed from: private */
    public Spinner sp4;
    /* access modifiers changed from: private */
    public Spinner sp5;
    TextView t;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    int th;
    int[] thang = {8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6};
    int[] thang2 = {5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3};
    int[] thang3 = {2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9};
    TextView tt;
    String tthang = "Yin";
    String[] tthanh1 = {" ", " ", "Jia - Ren", " ", " ", "Chou", "Xun", "Si", "Jia", "Wu", "Ding", " ", "Xun - Kun", "Si - Shen", " ", "You - Wu", "Xin - Ding", "Xu", "Kun", "Shen", "Ren", "You", "Xin", "Xu - Chou"};
    String[] tthanh2 = {"Qian", "Hai", " ", "Mao - Zi", "Yi - Gui", "Chou", "Xun", "Si", "Bing", "Mao", "Yi", "Wei", "Xun", "Si", "Geng - Bing", " ", " ", "Wei", "Qian", "Hai", "Geng", "Zi", "Gui", "Chou"};
    String[] tthanh3 = {" ", " ", "Ren", "Mao", "Yi", "Chou - Chen", " ", " ", " ", "Wu - Mao", "Ding - Yi", "Chen", "Kun", "Shen", "Geng", "Wu", "Ding", "Xu", "Kun", "Shen", "Ren", "You", "Xin", "Xu - Chou"};
    String[] tthanh4 = {"Gen", "Yin", "Jia", "Zi", "Gui", " ", "Gen - Xun", "Yin - Si", "Bing - Jia", " ", " ", " ", "Xun - Kun", "Si - Shen", "Geng - Bing", " ", " ", "Xu", "Kun", "Shen", "Geng", "Zi", "Gui", "Xu"};
    String[] tthanh5 = {" ", " ", " ", "Mao - Zi", "Yi - Gui", "Chou - Chen", " ", " ", " ", "Wu - Mao", "Ding - Yi", "Chen - Wei", " ", " ", " ", "You - Wu", "Xin - Ding", "Wei - Xu", " ", " ", " ", "Zi - You", "Gui - Xin", "Xu - Chou"};
    String[] tthanh6 = {"Gen", "Yin", "Jia", "Zi", "Gui", "Chen", "Gen", "Yin", "Jia", "Wu", "Ding", "Chen", "Kun", "Shen", "Geng", "Wu", "Ding", "Xu", "Kun", "Shen", "Geng", "Zi", "Gui", "Xu"};
    String[] tthanh7 = {"Gen", "Yin", " ", "Mao - Zi", "Yi - Gui", "Chen", "Gen", "Yin", "Bing", "Mao", "Yi", "Chen - Wei", " ", " ", "Bing", "You", "Xin", "Wei - Xu", " ", " ", " ", "Zi - You", "Gui - Xin", "Xu"};
    String[] tthanh8 = {"Qian", "Hai", "Jia - Ren", " ", " ", "Chou", "Xun", "Si", "Jia", "Wu", "Ding", "Wei", "Xun", "Si", " ", "You - Wu", "Xin - Ding", "Wei", "Qian", "Hai", "Ren", "You", "Xin", "Chou"};
    String[] tthanh9 = {"Qian - Gen", "Hai - Yin", " ", "Mao - Zi", "Yi - Gui", "Chen", "Gen", "Yin", "Bing", "Mao", "Yi", "Chen - Wei", " ", " ", "Geng - Bing", " ", " ", "Wei", "Qian", "Hai", "Geng", "Zi", "Gui", " "};
    String[] ttoa = {"Wu", "Ding", "Wei", "Kun", "Shen", "Geng", "You", "Xin", "Xu", "Qian", "Hai", "Ren", "Zi", "Gui", "Chou", "Gen", "Yin", "Jia", "Mao", "Yi", "Chen", "Xun", "Si", "Bing"};
    TextView tvt;
    int[] val = new int[9];
    int[] val2 = new int[9];
    int[] val3 = new int[9];
    String van;
    int[] vann = {4, 5, 6, 7, 8, 9, 1, 2, 3};
    int vanz = 8;
    int vi1;
    int vi2;
    int vi3;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == 3) {
            new ArrayList();
            Bundle extras = intent.getExtras();
            String[] split = extras.getStringArrayList("ghi").get(extras.getInt("giocz")).split(",");
            String trim = split[1].trim().split(" ")[0].trim();
            String str = split[2].trim().split(" ")[1];
            int i3 = 0;
            for (int i4 = 0; i4 < this.data2.length; i4++) {
                if (trim.equals(this.data2[i4])) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            while (i6 < this.data.length) {
                int i7 = str.equals(this.data[i6]) ? i6 : i5;
                i6++;
                i5 = i7;
            }
            this.sp.setSelection(i5);
            this.sp2.setSelection(i3);
        }
    }

    public void onClick3(View view) {
        startActivity(new Intent(this, ac3.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        ((AdView) findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());
        this.dos = (TextView) findViewById(R.id.po);
        this.t = (TextView) findViewById(R.id.a54);
        this.tt = (TextView) findViewById(R.id.a55);
        this.t3 = (TextView) findViewById(R.id.a56);
        this.t4 = (TextView) findViewById(R.id.a57);
        this.t5 = (TextView) findViewById(R.id.a58);
        this.t6 = (TextView) findViewById(R.id.a59);
        this.tvt = (TextView) findViewById(R.id.tv);
        this.a1 = (TextView) findViewById(R.id.textViewa1);
        this.a2 = (TextView) findViewById(R.id.textViewa2);
        this.a3 = (TextView) findViewById(R.id.textViewa3);
        this.a4 = (TextView) findViewById(R.id.textViewa4);
        this.a5 = (TextView) findViewById(R.id.textViewa5);
        this.a6 = (TextView) findViewById(R.id.textViewa6);
        this.a7 = (TextView) findViewById(R.id.textViewa7);
        this.a8 = (TextView) findViewById(R.id.textViewa8);
        this.a9 = (TextView) findViewById(R.id.textViewa9);
        this.a10 = (TextView) findViewById(R.id.textViewa10);
        this.a11 = (TextView) findViewById(R.id.textViewa11);
        this.a12 = (TextView) findViewById(R.id.textViewa12);
        this.a13 = (TextView) findViewById(R.id.textViewa13);
        this.a14 = (TextView) findViewById(R.id.textViewa14);
        this.a15 = (TextView) findViewById(R.id.textViewa15);
        this.a16 = (TextView) findViewById(R.id.textViewa16);
        this.a17 = (TextView) findViewById(R.id.textViewa17);
        this.a18 = (TextView) findViewById(R.id.textViewa18);
        this.b1 = (TextView) findViewById(R.id.textViewb1);
        this.b2 = (TextView) findViewById(R.id.textViewb2);
        this.b3 = (TextView) findViewById(R.id.textViewb3);
        this.b4 = (TextView) findViewById(R.id.textViewb4);
        this.b5 = (TextView) findViewById(R.id.textViewb5);
        this.b6 = (TextView) findViewById(R.id.textViewb6);
        this.b7 = (TextView) findViewById(R.id.textViewb7);
        this.b8 = (TextView) findViewById(R.id.textViewb8);
        this.b9 = (TextView) findViewById(R.id.textViewb9);
        this.c1 = (TextView) findViewById(R.id.textViewc1);
        this.c2 = (TextView) findViewById(R.id.textViewc2);
        this.c3 = (TextView) findViewById(R.id.textViewc3);
        this.c4 = (TextView) findViewById(R.id.textViewc4);
        this.c5 = (TextView) findViewById(R.id.textViewc5);
        this.c6 = (TextView) findViewById(R.id.textViewc6);
        this.c7 = (TextView) findViewById(R.id.textViewc7);
        this.c8 = (TextView) findViewById(R.id.textViewc8);
        this.c9 = (TextView) findViewById(R.id.textViewc9);
        this.d1 = (TextView) findViewById(R.id.textViewt1);
        this.d2 = (TextView) findViewById(R.id.textViewt2);
        this.d3 = (TextView) findViewById(R.id.textViewt3);
        this.d4 = (TextView) findViewById(R.id.textViewt4);
        this.d5 = (TextView) findViewById(R.id.textViewt5);
        this.d6 = (TextView) findViewById(R.id.textViewt6);
        this.d7 = (TextView) findViewById(R.id.textViewt7);
        this.d8 = (TextView) findViewById(R.id.textViewt8);
        this.d9 = (TextView) findViewById(R.id.textViewt9);
        this.mui2 = (ImageView) findViewById(R.id.pointer2);
        getWindow().addFlags(128);
        this.bb1 = (Button) findViewById(R.id.bu2);
        this.bb2 = (Button) findViewById(R.id.b1);
        this.bb3 = (Button) findViewById(R.id.b3);
        this.sp = (Spinner) findViewById(R.id.spin);
        this.sp2 = (Spinner) findViewById(R.id.spin2);
        this.sp3 = (Spinner) findViewById(R.id.spin33);
        this.sp4 = (Spinner) findViewById(R.id.spin44);
        this.sp5 = (Spinner) findViewById(R.id.spin55);
        this.adapter = new listp(this, this.data, 0);
        this.adap2 = new listp(this, this.data2, 0);
        this.adap3 = new listp(this, this.data3, 0);
        this.adap4 = new listp(this, this.data4, 0);
        this.adap5 = new listp(this, this.data5, 1);
        this.a[0] = this.ma;
        this.a[1] = this.ma2;
        this.a[2] = this.ma3;
        this.a[3] = this.ma4;
        this.a[4] = this.ma5;
        this.a[5] = this.ma6;
        this.a[6] = this.ma7;
        this.a[7] = this.ma8;
        this.a[8] = this.ma9;
        this.a[9] = this.ma10;
        this.a[10] = this.ma11;
        this.a[11] = this.ma12;
        this.a[12] = this.ma13;
        this.a[13] = this.ma14;
        this.a[14] = this.ma15;
        this.a[15] = this.ma16;
        this.a[16] = this.ma17;
        this.a[17] = this.ma18;
        this.a[18] = this.ma19;
        this.a[19] = this.ma20;
        this.a[20] = this.ma21;
        this.a[21] = this.ma22;
        this.a[22] = this.ma23;
        this.a[23] = this.ma24;
        this.ax[0] = this.man;
        this.ax[1] = this.man2;
        this.ax[2] = this.man3;
        this.ax[3] = this.man4;
        this.ax[4] = this.man5;
        this.ax[5] = this.man6;
        this.ax[6] = this.man7;
        this.ax[7] = this.man8;
        this.ax[8] = this.man9;
        this.ax[9] = this.man10;
        this.ax[10] = this.man11;
        this.ax[11] = this.man12;
        this.ax[12] = this.man13;
        this.ax[13] = this.man14;
        this.ax[14] = this.man15;
        this.ax[15] = this.man16;
        this.ax[16] = this.man17;
        this.ax[17] = this.man18;
        this.ax[18] = this.man19;
        this.ax[19] = this.man20;
        this.ax[20] = this.man21;
        this.ax[21] = this.man22;
        this.ax[22] = this.man23;
        this.ax[23] = this.man24;
        this.ab[0] = this.k;
        this.ab[1] = this.k2;
        this.ab[2] = this.k3;
        this.ab[3] = this.k4;
        this.ab[4] = this.k5;
        this.ab[5] = this.k6;
        this.ab[6] = this.k7;
        this.ab[7] = this.k8;
        this.ab[8] = this.k9;
        this.ab[9] = this.k10;
        this.ab[10] = this.k11;
        this.ab[11] = this.k12;
        this.ab[12] = this.k13;
        this.ab[13] = this.k14;
        this.ab[14] = this.k15;
        this.ab[15] = this.k16;
        this.ab[16] = this.k17;
        this.ab[17] = this.k18;
        this.ab[18] = this.k19;
        this.ab[19] = this.k20;
        this.ab[20] = this.k21;
        this.ab[21] = this.k22;
        this.ab[22] = this.k23;
        this.ab[23] = this.k24;
        this.ax2[0] = this.ka;
        this.ax2[1] = this.ka2;
        this.ax2[2] = this.ka3;
        this.ax2[3] = this.ka4;
        this.ax2[4] = this.ka5;
        this.ax2[5] = this.ka6;
        this.ax2[6] = this.ka7;
        this.ax2[7] = this.ka8;
        this.ax2[8] = this.ka9;
        this.ax2[9] = this.ka10;
        this.ax2[10] = this.ka11;
        this.ax2[11] = this.ka12;
        this.ax2[12] = this.ka13;
        this.ax2[13] = this.ka14;
        this.ax2[14] = this.ka15;
        this.ax2[15] = this.ka16;
        this.ax2[16] = this.ka17;
        this.ax2[17] = this.ka18;
        this.ax2[18] = this.ka19;
        this.ax2[19] = this.ka20;
        this.ax2[20] = this.ka21;
        this.ax2[21] = this.ka22;
        this.ax2[22] = this.ka23;
        this.ax2[23] = this.ka24;
        this.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainActivity.this.van = MainActivity.this.sp.getSelectedItem().toString();
                for (int i2 = 0; i2 < MainActivity.this.data.length; i2++) {
                    if (MainActivity.this.van.equals(MainActivity.this.data[i2])) {
                        MainActivity.this.vi1 = i2;
                    }
                }
                MainActivity.this.vanz = MainActivity.this.vann[MainActivity.this.vi1];
                MainActivity.this.val[0] = MainActivity.this.vanz;
                for (int i3 = 1; i3 < 9; i3++) {
                    MainActivity.this.val[i3] = MainActivity.this.val[0] + i3;
                }
                for (int i4 = 0; i4 < 9; i4++) {
                    if (MainActivity.this.val[i4] > 9) {
                        MainActivity.this.val[i4] = MainActivity.this.val[i4] - 9;
                    }
                }
                MainActivity.this.set2(MainActivity.this.val, MainActivity.this.b1, MainActivity.this.b2, MainActivity.this.b3, MainActivity.this.b4, MainActivity.this.b5, MainActivity.this.b6, MainActivity.this.b7, MainActivity.this.b8, MainActivity.this.b9);
                MainActivity.this.sehu(MainActivity.this.vanz, MainActivity.this.vi2, MainActivity.this.a1, MainActivity.this.a3, MainActivity.this.a5, MainActivity.this.a7, MainActivity.this.a9, MainActivity.this.a11, MainActivity.this.a13, MainActivity.this.a15, MainActivity.this.a17, MainActivity.this.a2, MainActivity.this.a4, MainActivity.this.a6, MainActivity.this.a8, MainActivity.this.a10, MainActivity.this.a12, MainActivity.this.a14, MainActivity.this.a16, MainActivity.this.a18);
                MainActivity.this.thanhmon(MainActivity.this.th, MainActivity.this.vi1);
                MainActivity.this.tomau2(MainActivity.this.val, MainActivity.this.b5, MainActivity.this.b9, MainActivity.this.b6, MainActivity.this.b7, MainActivity.this.b2, MainActivity.this.b8, MainActivity.this.b3, MainActivity.this.b4, MainActivity.this.b1);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp.setAdapter(this.adapter);
        this.sp.setSelection(4);
        this.sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainActivity.this.doso = MainActivity.this.sp2.getSelectedItem().toString();
                for (int i2 = 0; i2 < MainActivity.this.data2.length; i2++) {
                    if (MainActivity.this.doso.equals(MainActivity.this.data2[i2])) {
                        MainActivity.this.vi2 = i2;
                    }
                }
                MainActivity.this.vanz = MainActivity.this.vann[MainActivity.this.vi1];
                MainActivity.this.sehu(MainActivity.this.vanz, MainActivity.this.vi2, MainActivity.this.a1, MainActivity.this.a3, MainActivity.this.a5, MainActivity.this.a7, MainActivity.this.a9, MainActivity.this.a11, MainActivity.this.a13, MainActivity.this.a15, MainActivity.this.a17, MainActivity.this.a2, MainActivity.this.a4, MainActivity.this.a6, MainActivity.this.a8, MainActivity.this.a10, MainActivity.this.a12, MainActivity.this.a14, MainActivity.this.a16, MainActivity.this.a18);
                MainActivity.this.thanhmon(MainActivity.this.th, MainActivity.this.vi1);
                if (MainActivity.this.vi2 == 1) {
                    MainActivity.this.mui2.setRotation(5.0f);
                }
                if (MainActivity.this.vi2 == 2) {
                    MainActivity.this.mui2.setRotation(10.0f);
                }
                if (MainActivity.this.vi2 == 3) {
                    MainActivity.this.mui2.setRotation(15.0f);
                }
                if (MainActivity.this.vi2 == 4) {
                    MainActivity.this.mui2.setRotation(20.0f);
                }
                if (MainActivity.this.vi2 == 5) {
                    MainActivity.this.mui2.setRotation(25.0f);
                }
                if (MainActivity.this.vi2 == 6) {
                    MainActivity.this.mui2.setRotation(30.0f);
                }
                if (MainActivity.this.vi2 == 7) {
                    MainActivity.this.mui2.setRotation(35.0f);
                }
                if (MainActivity.this.vi2 == 8) {
                    MainActivity.this.mui2.setRotation(40.0f);
                }
                if (MainActivity.this.vi2 == 9) {
                    MainActivity.this.mui2.setRotation(45.0f);
                }
                if (MainActivity.this.vi2 == 10) {
                    MainActivity.this.mui2.setRotation(50.0f);
                }
                if (MainActivity.this.vi2 == 11) {
                    MainActivity.this.mui2.setRotation(55.0f);
                }
                if (MainActivity.this.vi2 == 12) {
                    MainActivity.this.mui2.setRotation(60.0f);
                }
                if (MainActivity.this.vi2 == 13) {
                    MainActivity.this.mui2.setRotation(65.0f);
                }
                if (MainActivity.this.vi2 == 14) {
                    MainActivity.this.mui2.setRotation(70.0f);
                }
                if (MainActivity.this.vi2 == 15) {
                    MainActivity.this.mui2.setRotation(75.0f);
                }
                if (MainActivity.this.vi2 == 16) {
                    MainActivity.this.mui2.setRotation(80.0f);
                }
                if (MainActivity.this.vi2 == 17) {
                    MainActivity.this.mui2.setRotation(85.0f);
                }
                if (MainActivity.this.vi2 == 18) {
                    MainActivity.this.mui2.setRotation(90.0f);
                }
                if (MainActivity.this.vi2 == 19) {
                    MainActivity.this.mui2.setRotation(95.0f);
                }
                if (MainActivity.this.vi2 == 20) {
                    MainActivity.this.mui2.setRotation(100.0f);
                }
                if (MainActivity.this.vi2 == 21) {
                    MainActivity.this.mui2.setRotation(105.0f);
                }
                if (MainActivity.this.vi2 == 22) {
                    MainActivity.this.mui2.setRotation(110.0f);
                }
                if (MainActivity.this.vi2 == 23) {
                    MainActivity.this.mui2.setRotation(115.0f);
                }
                if (MainActivity.this.vi2 == 24) {
                    MainActivity.this.mui2.setRotation(120.0f);
                }
                if (MainActivity.this.vi2 == 25) {
                    MainActivity.this.mui2.setRotation(125.0f);
                }
                if (MainActivity.this.vi2 == 26) {
                    MainActivity.this.mui2.setRotation(130.0f);
                }
                if (MainActivity.this.vi2 == 27) {
                    MainActivity.this.mui2.setRotation(135.0f);
                }
                if (MainActivity.this.vi2 == 28) {
                    MainActivity.this.mui2.setRotation(140.0f);
                }
                if (MainActivity.this.vi2 == 29) {
                    MainActivity.this.mui2.setRotation(145.0f);
                }
                if (MainActivity.this.vi2 == 30) {
                    MainActivity.this.mui2.setRotation(150.0f);
                }
                if (MainActivity.this.vi2 == 31) {
                    MainActivity.this.mui2.setRotation(155.0f);
                }
                if (MainActivity.this.vi2 == 32) {
                    MainActivity.this.mui2.setRotation(160.0f);
                }
                if (MainActivity.this.vi2 == 33) {
                    MainActivity.this.mui2.setRotation(165.0f);
                }
                if (MainActivity.this.vi2 == 34) {
                    MainActivity.this.mui2.setRotation(170.0f);
                }
                if (MainActivity.this.vi2 == 35) {
                    MainActivity.this.mui2.setRotation(175.0f);
                }
                if (MainActivity.this.vi2 == 36) {
                    MainActivity.this.mui2.setRotation(180.0f);
                }
                if (MainActivity.this.vi2 == 37) {
                    MainActivity.this.mui2.setRotation(185.0f);
                }
                if (MainActivity.this.vi2 == 38) {
                    MainActivity.this.mui2.setRotation(190.0f);
                }
                if (MainActivity.this.vi2 == 39) {
                    MainActivity.this.mui2.setRotation(195.0f);
                }
                if (MainActivity.this.vi2 == 40) {
                    MainActivity.this.mui2.setRotation(200.0f);
                }
                if (MainActivity.this.vi2 == 41) {
                    MainActivity.this.mui2.setRotation(205.0f);
                }
                if (MainActivity.this.vi2 == 42) {
                    MainActivity.this.mui2.setRotation(210.0f);
                }
                if (MainActivity.this.vi2 == 43) {
                    MainActivity.this.mui2.setRotation(215.0f);
                }
                if (MainActivity.this.vi2 == 44) {
                    MainActivity.this.mui2.setRotation(220.0f);
                }
                if (MainActivity.this.vi2 == 45) {
                    MainActivity.this.mui2.setRotation(225.0f);
                }
                if (MainActivity.this.vi2 == 46) {
                    MainActivity.this.mui2.setRotation(230.0f);
                }
                if (MainActivity.this.vi2 == 47) {
                    MainActivity.this.mui2.setRotation(235.0f);
                }
                if (MainActivity.this.vi2 == 48) {
                    MainActivity.this.mui2.setRotation(240.0f);
                }
                if (MainActivity.this.vi2 == 49) {
                    MainActivity.this.mui2.setRotation(245.0f);
                }
                if (MainActivity.this.vi2 == 50) {
                    MainActivity.this.mui2.setRotation(250.0f);
                }
                if (MainActivity.this.vi2 == 51) {
                    MainActivity.this.mui2.setRotation(255.0f);
                }
                if (MainActivity.this.vi2 == 52) {
                    MainActivity.this.mui2.setRotation(260.0f);
                }
                if (MainActivity.this.vi2 == 53) {
                    MainActivity.this.mui2.setRotation(265.0f);
                }
                if (MainActivity.this.vi2 == 54) {
                    MainActivity.this.mui2.setRotation(270.0f);
                }
                if (MainActivity.this.vi2 == 55) {
                    MainActivity.this.mui2.setRotation(275.0f);
                }
                if (MainActivity.this.vi2 == 56) {
                    MainActivity.this.mui2.setRotation(280.0f);
                }
                if (MainActivity.this.vi2 == 57) {
                    MainActivity.this.mui2.setRotation(285.0f);
                }
                if (MainActivity.this.vi2 == 58) {
                    MainActivity.this.mui2.setRotation(290.0f);
                }
                if (MainActivity.this.vi2 == 59) {
                    MainActivity.this.mui2.setRotation(295.0f);
                }
                if (MainActivity.this.vi2 == 60) {
                    MainActivity.this.mui2.setRotation(300.0f);
                }
                if (MainActivity.this.vi2 == 61) {
                    MainActivity.this.mui2.setRotation(305.0f);
                }
                if (MainActivity.this.vi2 == 62) {
                    MainActivity.this.mui2.setRotation(310.0f);
                }
                if (MainActivity.this.vi2 == 63) {
                    MainActivity.this.mui2.setRotation(315.0f);
                }
                if (MainActivity.this.vi2 == 64) {
                    MainActivity.this.mui2.setRotation(320.0f);
                }
                if (MainActivity.this.vi2 == 65) {
                    MainActivity.this.mui2.setRotation(325.0f);
                }
                if (MainActivity.this.vi2 == 66) {
                    MainActivity.this.mui2.setRotation(330.0f);
                }
                if (MainActivity.this.vi2 == 67) {
                    MainActivity.this.mui2.setRotation(335.0f);
                }
                if (MainActivity.this.vi2 == 68) {
                    MainActivity.this.mui2.setRotation(340.0f);
                }
                if (MainActivity.this.vi2 == 69) {
                    MainActivity.this.mui2.setRotation(345.0f);
                }
                if (MainActivity.this.vi2 == 70) {
                    MainActivity.this.mui2.setRotation(350.0f);
                }
                if (MainActivity.this.vi2 == 71) {
                    MainActivity.this.mui2.setRotation(355.0f);
                }
                if (MainActivity.this.vi2 == 0) {
                    MainActivity.this.mui2.setRotation(360.0f);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp2.setAdapter(this.adap2);
        String[] split = new Date().toString().trim().split(" ");
        String str = split[split.length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < this.data3.length; i3++) {
            if (str.equals(this.data3[i3])) {
                i2 = i3;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 12; i5++) {
            if (split[1].equals(this.data44[i5])) {
                i4 = i5;
            }
        }
        int i6 = i4 - 1;
        if (i6 < 0) {
            i6 = 11;
        }
        if (i2 < 33) {
            i2 = 33;
        } else {
            i = i6;
        }
        this.sonam = Integer.parseInt(this.data3[i2]);
        this.sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainActivity.this.luu = MainActivity.this.sp3.getSelectedItem().toString();
                MainActivity.this.sonam = Integer.parseInt(MainActivity.this.luu);
                int i2 = 0;
                for (int i3 = 0; i3 < MainActivity.this.data3.length; i3++) {
                    if (MainActivity.this.luu.equals(MainActivity.this.data3[i3])) {
                        MainActivity.this.vi3 = MainActivity.this.saol[i3];
                        i2 = i3;
                    }
                }
                int i4 = 0;
                for (int i5 = 0; i5 < MainActivity.this.data5.length; i5++) {
                    if (MainActivity.this.tthang.equals(MainActivity.this.data5[i5])) {
                        i4 = i5;
                    }
                }
                if (i4 == 11) {
                    if (MainActivity.this.sonam == 1984) {
                        MainActivity.this.sonam = 1983;
                        MainActivity.this.vi3 = 8;
                    } else {
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.sonam--;
                        MainActivity.this.vi3 = MainActivity.this.saol[i2 - 1];
                    }
                }
                if (MainActivity.this.sonam % 3 == 0) {
                    MainActivity.this.val3[0] = MainActivity.this.thang3[i4];
                } else if (MainActivity.this.sonam % 3 == 1) {
                    MainActivity.this.val3[0] = MainActivity.this.thang[i4];
                } else {
                    MainActivity.this.val3[0] = MainActivity.this.thang2[i4];
                }
                for (int i6 = 1; i6 < 9; i6++) {
                    MainActivity.this.val3[i6] = MainActivity.this.val3[0] + i6;
                }
                for (int i7 = 0; i7 < 9; i7++) {
                    if (MainActivity.this.val3[i7] > 9) {
                        MainActivity.this.val3[i7] = MainActivity.this.val3[i7] - 9;
                    }
                }
                MainActivity.this.val2[0] = MainActivity.this.vi3;
                for (int i8 = 1; i8 < 9; i8++) {
                    MainActivity.this.val2[i8] = MainActivity.this.val2[0] + i8;
                }
                for (int i9 = 0; i9 < 9; i9++) {
                    if (MainActivity.this.val2[i9] > 9) {
                        MainActivity.this.val2[i9] = MainActivity.this.val2[i9] - 9;
                    }
                }
                if (MainActivity.this.co.equals("Show")) {
                    MainActivity.this.set22(MainActivity.this.val2, MainActivity.this.c1, MainActivity.this.c2, MainActivity.this.c3, MainActivity.this.c4, MainActivity.this.c5, MainActivity.this.c6, MainActivity.this.c7, MainActivity.this.c8, MainActivity.this.c9);
                    MainActivity.this.set22(MainActivity.this.val3, MainActivity.this.d1, MainActivity.this.d2, MainActivity.this.d3, MainActivity.this.d4, MainActivity.this.d5, MainActivity.this.d6, MainActivity.this.d7, MainActivity.this.d8, MainActivity.this.d9);
                    return;
                }
                MainActivity.this.set33(MainActivity.this.c1, MainActivity.this.c2, MainActivity.this.c3, MainActivity.this.c4, MainActivity.this.c5, MainActivity.this.c6, MainActivity.this.c7, MainActivity.this.c8, MainActivity.this.c9);
                MainActivity.this.set33(MainActivity.this.d1, MainActivity.this.d2, MainActivity.this.d3, MainActivity.this.d4, MainActivity.this.d5, MainActivity.this.d6, MainActivity.this.d7, MainActivity.this.d8, MainActivity.this.d9);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp3.setAdapter(this.adap3);
        this.sp3.setSelection(i2);
        this.sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainActivity.this.co = MainActivity.this.sp4.getSelectedItem().toString();
                int i2 = 0;
                for (int i3 = 0; i3 < MainActivity.this.data5.length; i3++) {
                    if (MainActivity.this.tthang.equals(MainActivity.this.data5[i3])) {
                        i2 = i3;
                    }
                }
                if (MainActivity.this.sonam % 3 == 0) {
                    MainActivity.this.val3[0] = MainActivity.this.thang3[i2];
                } else if (MainActivity.this.sonam % 3 == 1) {
                    MainActivity.this.val3[0] = MainActivity.this.thang[i2];
                } else {
                    MainActivity.this.val3[0] = MainActivity.this.thang2[i2];
                }
                for (int i4 = 1; i4 < 9; i4++) {
                    MainActivity.this.val3[i4] = MainActivity.this.val3[0] + i4;
                }
                for (int i5 = 0; i5 < 9; i5++) {
                    if (MainActivity.this.val3[i5] > 9) {
                        MainActivity.this.val3[i5] = MainActivity.this.val3[i5] - 9;
                    }
                }
                if (MainActivity.this.co.equals("Show")) {
                    MainActivity.this.set22(MainActivity.this.val2, MainActivity.this.c1, MainActivity.this.c2, MainActivity.this.c3, MainActivity.this.c4, MainActivity.this.c5, MainActivity.this.c6, MainActivity.this.c7, MainActivity.this.c8, MainActivity.this.c9);
                    MainActivity.this.set22(MainActivity.this.val3, MainActivity.this.d1, MainActivity.this.d2, MainActivity.this.d3, MainActivity.this.d4, MainActivity.this.d5, MainActivity.this.d6, MainActivity.this.d7, MainActivity.this.d8, MainActivity.this.d9);
                    return;
                }
                MainActivity.this.set33(MainActivity.this.c1, MainActivity.this.c2, MainActivity.this.c3, MainActivity.this.c4, MainActivity.this.c5, MainActivity.this.c6, MainActivity.this.c7, MainActivity.this.c8, MainActivity.this.c9);
                MainActivity.this.set33(MainActivity.this.d1, MainActivity.this.d2, MainActivity.this.d3, MainActivity.this.d4, MainActivity.this.d5, MainActivity.this.d6, MainActivity.this.d7, MainActivity.this.d8, MainActivity.this.d9);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp4.setAdapter(this.adap4);
        this.sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainActivity.this.tthang = MainActivity.this.sp5.getSelectedItem().toString();
                MainActivity.this.sonam = Integer.parseInt(MainActivity.this.luu);
                int i2 = 0;
                for (int i3 = 0; i3 < MainActivity.this.data3.length; i3++) {
                    if (MainActivity.this.luu.equals(MainActivity.this.data3[i3])) {
                        MainActivity.this.vi3 = MainActivity.this.saol[i3];
                        i2 = i3;
                    }
                }
                int i4 = 0;
                for (int i5 = 0; i5 < MainActivity.this.data5.length; i5++) {
                    if (MainActivity.this.tthang.equals(MainActivity.this.data5[i5])) {
                        i4 = i5;
                    }
                }
                if (i4 == 11) {
                    if (MainActivity.this.sonam == 1984) {
                        MainActivity.this.sonam = 1983;
                        MainActivity.this.vi3 = 8;
                    } else {
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.sonam--;
                        MainActivity.this.vi3 = MainActivity.this.saol[i2 - 1];
                    }
                }
                if (MainActivity.this.sonam % 3 == 0) {
                    MainActivity.this.val3[0] = MainActivity.this.thang3[i4];
                } else if (MainActivity.this.sonam % 3 == 1) {
                    MainActivity.this.val3[0] = MainActivity.this.thang[i4];
                } else {
                    MainActivity.this.val3[0] = MainActivity.this.thang2[i4];
                }
                for (int i6 = 1; i6 < 9; i6++) {
                    MainActivity.this.val3[i6] = MainActivity.this.val3[0] + i6;
                }
                for (int i7 = 0; i7 < 9; i7++) {
                    if (MainActivity.this.val3[i7] > 9) {
                        MainActivity.this.val3[i7] = MainActivity.this.val3[i7] - 9;
                    }
                }
                MainActivity.this.val2[0] = MainActivity.this.vi3;
                for (int i8 = 1; i8 < 9; i8++) {
                    MainActivity.this.val2[i8] = MainActivity.this.val2[0] + i8;
                }
                for (int i9 = 0; i9 < 9; i9++) {
                    if (MainActivity.this.val2[i9] > 9) {
                        MainActivity.this.val2[i9] = MainActivity.this.val2[i9] - 9;
                    }
                }
                if (MainActivity.this.co.equals("Show")) {
                    MainActivity.this.set22(MainActivity.this.val2, MainActivity.this.c1, MainActivity.this.c2, MainActivity.this.c3, MainActivity.this.c4, MainActivity.this.c5, MainActivity.this.c6, MainActivity.this.c7, MainActivity.this.c8, MainActivity.this.c9);
                    MainActivity.this.set22(MainActivity.this.val3, MainActivity.this.d1, MainActivity.this.d2, MainActivity.this.d3, MainActivity.this.d4, MainActivity.this.d5, MainActivity.this.d6, MainActivity.this.d7, MainActivity.this.d8, MainActivity.this.d9);
                    return;
                }
                MainActivity.this.set33(MainActivity.this.c1, MainActivity.this.c2, MainActivity.this.c3, MainActivity.this.c4, MainActivity.this.c5, MainActivity.this.c6, MainActivity.this.c7, MainActivity.this.c8, MainActivity.this.c9);
                MainActivity.this.set33(MainActivity.this.d1, MainActivity.this.d2, MainActivity.this.d3, MainActivity.this.d4, MainActivity.this.d5, MainActivity.this.d6, MainActivity.this.d7, MainActivity.this.d8, MainActivity.this.d9);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sp5.setAdapter(this.adap5);
        this.sp5.setSelection(i);
        this.bb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, doc.class));
            }
        });
        this.bb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, luu.class);
                Bundle bundle = new Bundle();
                bundle.putString("giocz", String.valueOf(MainActivity.this.doso) + " degrees, " + "period " + MainActivity.this.van);
                intent.putExtras(bundle);
                MainActivity.this.startActivity(intent);
            }
        });
        this.bb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this.getBaseContext(), danhsach.class), 1);
            }
        });
        this.bb4 = (Button) findViewById(R.id.b4);
        this.bb4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, dohuong.class));
            }
        });
        this.a1.setTextSize(1, 20.0f);
        this.a2.setTextSize(1, 20.0f);
        this.a3.setTextSize(1, 20.0f);
        this.a4.setTextSize(1, 20.0f);
        this.a5.setTextSize(1, 20.0f);
        this.a6.setTextSize(1, 20.0f);
        this.a7.setTextSize(1, 20.0f);
        this.a8.setTextSize(1, 20.0f);
        this.a9.setTextSize(1, 20.0f);
        this.a10.setTextSize(1, 20.0f);
        this.a12.setTextSize(1, 20.0f);
        this.a13.setTextSize(1, 20.0f);
        this.a14.setTextSize(1, 20.0f);
        this.a15.setTextSize(1, 20.0f);
        this.a16.setTextSize(1, 20.0f);
        this.a17.setTextSize(1, 20.0f);
        this.a18.setTextSize(1, 20.0f);
        this.a11.setTextSize(1, 20.0f);
        this.b1.setTextSize(1, 20.0f);
        this.b2.setTextSize(1, 20.0f);
        this.b3.setTextSize(1, 20.0f);
        this.b4.setTextSize(1, 20.0f);
        this.b5.setTextSize(1, 20.0f);
        this.b6.setTextSize(1, 20.0f);
        this.b7.setTextSize(1, 20.0f);
        this.b8.setTextSize(1, 20.0f);
        this.b9.setTextSize(1, 20.0f);
        this.c1.setTextSize(1, 18.0f);
        this.c2.setTextSize(1, 18.0f);
        this.c3.setTextSize(1, 18.0f);
        this.c4.setTextSize(1, 18.0f);
        this.c5.setTextSize(1, 18.0f);
        this.c6.setTextSize(1, 18.0f);
        this.c7.setTextSize(1, 18.0f);
        this.c8.setTextSize(1, 18.0f);
        this.c9.setTextSize(1, 18.0f);
        this.d1.setTextSize(1, 18.0f);
        this.d2.setTextSize(1, 18.0f);
        this.d3.setTextSize(1, 18.0f);
        this.d4.setTextSize(1, 18.0f);
        this.d5.setTextSize(1, 18.0f);
        this.d6.setTextSize(1, 18.0f);
        this.d7.setTextSize(1, 18.0f);
        this.d8.setTextSize(1, 18.0f);
        this.d9.setTextSize(1, 18.0f);
        this.bb1.setTextSize(1, 15.0f);
        this.bb2.setTextSize(1, 15.0f);
        this.bb3.setTextSize(1, 15.0f);
        this.bb4.setTextSize(1, 15.0f);
        this.t.setTextSize(1, 14.0f);
        this.tt.setTextSize(1, 15.0f);
        this.t3.setTextSize(1, 13.0f);
        this.t4.setTextSize(1, 13.0f);
        this.t5.setTextSize(1, 13.0f);
        this.t6.setTextSize(1, 13.0f);
    }

    public void sehu(int i, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3 = new int[9];
        int[] iArr4 = new int[9];
        int[] iArr5 = new int[18];
        int[] iArr6 = new int[18];
        String str = i == 1 ? "Period 1" : i == 2 ? "Period 2" : i == 3 ? "Period 3" : i == 4 ? "Period 4" : i == 5 ? "Period 5" : i == 6 ? "Period 6" : i == 7 ? "Period 7" : i == 8 ? "Period 8" : "Period 9";
        if (i2 % 3 == 0) {
            int i3 = i2 / 3;
            iArr = (int[]) this.a[i3];
            iArr2 = (int[]) this.ax[i3];
            this.th = i3;
            this.t.setText("Sitting " + this.ttoa[this.th] + " - " + "Facing " + this.hhuong[this.th] + " - " + str);
        } else if (i2 % 3 == 1) {
            int i4 = (i2 - 1) / 3;
            iArr = (int[]) this.ab[i4];
            iArr2 = (int[]) this.ax2[i4];
            this.th = i4;
            if (this.th == 23) {
                this.t.setText("Sitting " + this.ttoa[this.th] + ", " + "Facing " + this.hhuong[this.th] + " - Near " + this.ttoa[0] + " " + this.hhuong[0] + " - " + str);
            } else {
                this.t.setText("Sitting " + this.ttoa[this.th] + ", " + "Facing " + this.hhuong[this.th] + " - Near " + this.ttoa[this.th + 1] + " " + this.hhuong[this.th + 1] + " - " + str);
            }
        } else {
            int i5 = (i2 + 1) / 3;
            int i6 = i5 == 24 ? 0 : i5;
            iArr = (int[]) this.ab[i6];
            iArr2 = (int[]) this.ax2[i6];
            this.th = i6;
            if (this.th == 0) {
                this.t.setText("Sitting " + this.ttoa[this.th] + ", " + "Facing " + this.hhuong[this.th] + " - Near " + this.ttoa[23] + " " + this.hhuong[23] + " - " + str);
            } else {
                this.t.setText("Sitting " + this.ttoa[this.th] + ", " + "Facing " + this.hhuong[this.th] + " - Near " + this.ttoa[this.th - 1] + " " + this.hhuong[this.th - 1] + " - " + str);
            }
        }
        int i7 = (i * 2) - 1;
        iArr3[0] = iArr[i7];
        iArr4[0] = iArr[i7 - 1];
        int i8 = iArr2[i7];
        int i9 = iArr2[i7 - 1];
        if (i8 == 1) {
            for (int i10 = 1; i10 < 9; i10++) {
                iArr3[i10] = iArr3[0] + i10;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                if (iArr3[i11] > 9) {
                    iArr3[i11] = iArr3[i11] - 9;
                }
            }
        } else {
            for (int i12 = 1; i12 < 9; i12++) {
                iArr3[i12] = iArr3[0] - i12;
            }
            for (int i13 = 0; i13 < 9; i13++) {
                if (iArr3[i13] < 1) {
                    iArr3[i13] = iArr3[i13] + 9;
                }
            }
        }
        if (i9 == 1) {
            for (int i14 = 1; i14 < 9; i14++) {
                iArr4[i14] = iArr4[0] + i14;
            }
            for (int i15 = 0; i15 < 9; i15++) {
                if (iArr4[i15] > 9) {
                    iArr4[i15] = iArr4[i15] - 9;
                }
            }
        } else {
            for (int i16 = 1; i16 < 9; i16++) {
                iArr4[i16] = iArr4[0] - i16;
            }
            for (int i17 = 0; i17 < 9; i17++) {
                if (iArr4[i17] < 1) {
                    iArr4[i17] = iArr4[i17] + 9;
                }
            }
        }
        set2(iArr4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
        set2(iArr3, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
        tomau(new int[]{iArr4[8], iArr4[4], iArr4[6], iArr4[7], iArr4[0], iArr4[2], iArr4[3], iArr4[5], iArr4[1], iArr3[8], iArr3[4], iArr3[6], iArr3[7], iArr3[0], iArr3[2], iArr3[3], iArr3[5], iArr3[1]}, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18);
    }

    public void set(int[] iArr, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        textView.setText(new StringBuilder(String.valueOf(iArr[0])).toString());
        textView2.setText(new StringBuilder(String.valueOf(iArr[1])).toString());
        textView3.setText(new StringBuilder(String.valueOf(iArr[2])).toString());
        textView4.setText(new StringBuilder(String.valueOf(iArr[3])).toString());
        textView5.setText(new StringBuilder(String.valueOf(iArr[4])).toString());
        textView6.setText(new StringBuilder(String.valueOf(iArr[5])).toString());
        textView7.setText(new StringBuilder(String.valueOf(iArr[6])).toString());
        textView8.setText(new StringBuilder(String.valueOf(iArr[7])).toString());
        textView9.setText(new StringBuilder(String.valueOf(iArr[8])).toString());
        textView10.setText(new StringBuilder(String.valueOf(iArr[9])).toString());
        textView11.setText(new StringBuilder(String.valueOf(iArr[10])).toString());
        textView12.setText(new StringBuilder(String.valueOf(iArr[11])).toString());
        textView13.setText(new StringBuilder(String.valueOf(iArr[12])).toString());
        textView14.setText(new StringBuilder(String.valueOf(iArr[13])).toString());
        textView15.setText(new StringBuilder(String.valueOf(iArr[14])).toString());
        textView16.setText(new StringBuilder(String.valueOf(iArr[15])).toString());
        textView17.setText(new StringBuilder(String.valueOf(iArr[16])).toString());
        textView18.setText(new StringBuilder(String.valueOf(iArr[17])).toString());
    }

    public void set2(int[] iArr, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        textView.setText(new StringBuilder(String.valueOf(iArr[8])).toString());
        textView2.setText(new StringBuilder(String.valueOf(iArr[4])).toString());
        textView3.setText(new StringBuilder(String.valueOf(iArr[6])).toString());
        textView4.setText(new StringBuilder(String.valueOf(iArr[7])).toString());
        textView5.setText(new StringBuilder(String.valueOf(iArr[0])).toString());
        textView6.setText(new StringBuilder(String.valueOf(iArr[2])).toString());
        textView7.setText(new StringBuilder(String.valueOf(iArr[3])).toString());
        textView8.setText(new StringBuilder(String.valueOf(iArr[5])).toString());
        textView9.setText(new StringBuilder(String.valueOf(iArr[1])).toString());
    }

    public void set22(int[] iArr, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        textView.setText(new StringBuilder(String.valueOf(iArr[8])).toString());
        textView2.setText(new StringBuilder(String.valueOf(iArr[4])).toString());
        textView3.setText(new StringBuilder(String.valueOf(iArr[6])).toString());
        textView4.setText(new StringBuilder(String.valueOf(iArr[7])).toString());
        textView5.setText(new StringBuilder(String.valueOf(iArr[0])).toString());
        textView6.setText(new StringBuilder(String.valueOf(iArr[2])).toString());
        textView7.setText(new StringBuilder(String.valueOf(iArr[3])).toString());
        textView8.setText(new StringBuilder(String.valueOf(iArr[5])).toString());
        textView9.setText(new StringBuilder(String.valueOf(iArr[1])).toString());
    }

    public void set33(TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        textView.setText(" ");
        textView2.setText(" ");
        textView3.setText(" ");
        textView4.setText(" ");
        textView5.setText(" ");
        textView6.setText(" ");
        textView7.setText(" ");
        textView8.setText(" ");
        textView9.setText(" ");
    }

    public void thanhmon(int i, int i2) {
        if (i2 == 0) {
            if (this.tthanh4[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh4[i]);
            }
        } else if (i2 == 1) {
            if (this.tthanh5[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh5[i]);
            }
        } else if (i2 == 2) {
            if (this.tthanh6[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh6[i]);
            }
        } else if (i2 == 3) {
            if (this.tthanh7[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh7[i]);
            }
        } else if (i2 == 4) {
            if (this.tthanh8[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh8[i]);
            }
        } else if (i2 == 5) {
            if (this.tthanh9[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh9[i]);
            }
        } else if (i2 == 6) {
            if (this.tthanh1[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh1[i]);
            }
        } else if (i2 == 7) {
            if (this.tthanh2[i].equals(" ")) {
                this.tt.setText("No good gate");
            } else {
                this.tt.setText("Good gate at " + this.tthanh2[i]);
            }
        } else if (this.tthanh3[i].equals(" ")) {
            this.tt.setText("No good gate");
        } else {
            this.tt.setText("Good gate at " + this.tthanh3[i]);
        }
    }

    public void tomau(int[] iArr, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        Object[] objArr = {textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18};
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 18) {
                if (iArr[i2] == 1) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#000000"));
                }
                if (iArr[i2] == 6 || iArr[i2] == 7) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#a2a2d0"));
                }
                if (iArr[i2] == 9) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#ff0800"));
                }
                if (iArr[i2] == 3 || iArr[i2] == 4) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#ff008000"));
                }
                if (iArr[i2] == 2 || iArr[i2] == 5 || iArr[i2] == 8) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#ffa700"));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void tomau2(int[] iArr, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        Object[] objArr = {textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9};
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 9) {
                if (iArr[i2] == 1) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#000000"));
                }
                if (iArr[i2] == 6 || iArr[i2] == 7) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#a2a2d0"));
                }
                if (iArr[i2] == 9) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#ff0800"));
                }
                if (iArr[i2] == 3 || iArr[i2] == 4) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#ff008000"));
                }
                if (iArr[i2] == 2 || iArr[i2] == 5 || iArr[i2] == 8) {
                    ((TextView) objArr[i2]).setTextColor(Color.parseColor("#ffa700"));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
