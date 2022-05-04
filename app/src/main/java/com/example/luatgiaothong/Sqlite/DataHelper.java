package com.example.luatgiaothong.Sqlite;

import static com.example.luatgiaothong.HomeFragment.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.luatgiaothong.Entity.CapNhat;
import com.example.luatgiaothong.Entity.CauHoiEntity;
import com.example.luatgiaothong.Entity.ChiTietDe;
import com.example.luatgiaothong.Entity.DapAnEntity;
import com.example.luatgiaothong.Entity.DeThi;
import com.example.luatgiaothong.Entity.LoaiCH;
import com.example.luatgiaothong.Entity.MeoThi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataHelper extends SQLiteOpenHelper {
    public DataHelper(@Nullable Context context) {
        super(context, "LuatGT", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LOAICH (MALCH ntext primary key, TENLCH ntext, GHICHU ntext)");
        sqLiteDatabase.execSQL("CREATE TABLE CAUHOI(\n" +
                "\tMACH INT PRIMARY KEY,\n" +
                "\tNOIDUNG NTEXT,\n" +
                "\tHINHANH NTEXT,\n" +
                "\tMALCH INT\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE DAPAN(\n" +
                "\tMADAPAN INT PRIMARY KEY,\n" +
                "\tMACH INT ,\n" +
                "\tDAPAN NTEXT,\n" +
                "\tKIEMTRA NTEXT\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE BODE(\n" +
                "\tMABODE INT PRIMARY KEY,\n" +
                "\tGHICHU NTEXT\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE CHITIETDE(\n" +
                "\tMABODE INT,\n" +
                "\tMACH INT,\n" +
                "\tPRIMARY KEY(MABODE,MACH)\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE LAMDE(\n" +
                "\tMABODE INT,\n" +
                "\tMACH INT,\n" +
                "\tMADAPAN INT,\n" +
                "\tPRIMARY KEY(MABODE,MACH,MADAPAN)\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE CAPNHAT(\n" +
                "\tMACN int primary key,\n" +
                "\tTENBANCN nvarchar(10)\n" +
                "\t)");
        sqLiteDatabase.execSQL("CREATE TABLE MEOTHI(\n" +
                "\tMAMEO INT PRIMARY KEY,\n" +
                "\tTENMEO NTEXT,\n" +
                "\tNOIDUNG NTEXT\n" +
                "\t)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertCN(CapNhat cn) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MACN", cn.getMACN());
        values.put("TENBANCN", cn.getTenCN());
        database.insert("CAPNHAT", null, values);
        database.close();
    }

    public void insertMT(MeoThi meoThi) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MAMEO", meoThi.getMaMeo());
        values.put("TENMEO", meoThi.getTitle());
        values.put("NOIDUNG", meoThi.getContent());
        database.insert("MEOTHI", null, values);
        database.close();
    }

    public void deleteAllMeo() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM MEOTHI";
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.executeInsert();
    }

    public void insertLCH(LoaiCH lvh) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MALCH", lvh.getMaLCH());
        values.put("TENLCH", lvh.getTenLCH());
        values.put("GHICHU", lvh.getGhiChu());
        database.insert("LOAICH", null, values);
        database.close();
    }

    public void insertDT(DeThi dt) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MABODE", dt.getMaDe());
        values.put("GHICHU", dt.getGhiChu());
        database.insert("BODE", null, values);
        database.close();
    }

    public void insertCTD(ChiTietDe dt) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MABODE", dt.getMABODE());
        values.put("MACH", dt.getMACH());
        database.insert("CHITIETDE", null, values);
        database.close();
    }

    public void deleteAllBODE() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM BODE";
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.executeInsert();
    }

    public void deleteAllCH() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM CAUHOI";
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.executeInsert();
    }

    public void deleteAllLCH() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM LOAICH";
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.executeInsert();
    }

    public void deleteAllDA() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM DAPAN";
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.executeInsert();
    }

    public void deleteAllCTD() {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM CHITIETDE";
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.executeInsert();
    }

    public void insertCH(CauHoiEntity ch) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MACH", ch.getMaCH());
        values.put("NOIDUNG", ch.getNoiDung());
        values.put("HINHANH", ch.getHinhAnh());
        values.put("MALCH", ch.getMaLCH());
        database.insert("CAUHOI", null, values);
        database.close();
    }

    public void insertDA(DapAnEntity da) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MADAPAN", da.getMaDA());
        values.put("MACH", da.getMaCH());
        values.put("DAPAN", da.getDapAN());
        values.put("KIEMTRA", da.getKiemTra() + "");


        database.insert("DAPAN", null, values);
        database.close();
    }

    public CapNhat getCapNhat() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM CAPNHAT", null);
        CapNhat cn = new CapNhat();
        List<CapNhat> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CapNhat dt = new CapNhat(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
            list.add(dt);
            cursor.moveToNext();
        }
        database.close();
        cn = list.get(list.size() - 1);
        return cn;
    }

    public List<DeThi> getAll() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM BODE", null);
        List<DeThi> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DeThi dt = new DeThi(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
            list.add(dt);
            cursor.moveToNext();
        }
        database.close();
        return list;
    }

    public List<CauHoiEntity> getAllCauHoi() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM CAUHOI", null);
        List<CauHoiEntity> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Log.e("TAG", cursor.getString(0) + "");
            CauHoiEntity dt = new CauHoiEntity(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
            list.add(dt);
            cursor.moveToNext();
        }
        database.close();
        return list;
    }

    public List<LoaiCH> getAllLoaiCauHoi() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM LOAICH", null);
        List<LoaiCH> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            LoaiCH dt = new LoaiCH(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
            list.add(dt);
            cursor.moveToNext();
        }
        database.close();
        return list;
    }



    public List<MeoThi> getAllMeoThi() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM MEOTHI", null);
        List<MeoThi> list = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MeoThi mt = new MeoThi(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            list.add(mt);
            cursor.moveToNext();
        }
        database.close();
        return list;
    }
    public List<CauHoiEntity> getBoDe(int bode) {
        SQLiteDatabase database = getReadableDatabase();
        int s = 0;
        Cursor cursor = database.rawQuery("SELECT CH.MACH,CH.NOIDUNG,CH.HINHANH,CH.MADAPAN,CH.DAPAN,CH.KIEMTRA  FROM CHITIETDE CTD,(select ch.MACH,ch.NOIDUNG,ch.HINHANH,da.MADAPAN,da.DAPAN,da.KIEMTRA from CAUHOI ch, DAPAN da\n" +
                "where ch.MACH=da.MACH) CH\n" +
                "WHERE CTD.MACH=CH.MACH AND CTD.MABODE="+bode+"", null);
        //List<DapAnEntity> list = new ArrayList<>();
        List<CauHoiEntity> entities = new ArrayList<>();
        CauHoiEntity cauHoiEntity = new CauHoiEntity();
        cursor.moveToFirst();
        s = Integer.parseInt(cursor.getString(0));
        while (!cursor.isAfterLast()) {
            DapAnEntity dapAnEntity = new DapAnEntity();
            if (s != Integer.parseInt(cursor.getString(0))) {
                if (s != 0) {
                    entities.add(cauHoiEntity);
                    cauHoiEntity = new CauHoiEntity();
                    s = Integer.parseInt(cursor.getString(0));
                    cauHoiEntity.setMaCH(Integer.parseInt(cursor.getString(0)));
                    cauHoiEntity.setNoiDung(cursor.getString(1));
                    cauHoiEntity.setHinhAnh(cursor.getString(2));
                }
            } else {
                s = Integer.parseInt(cursor.getString(0));
                cauHoiEntity.setMaCH(Integer.parseInt(cursor.getString(0)));
                cauHoiEntity.setNoiDung(cursor.getString(1));
                cauHoiEntity.setHinhAnh(cursor.getString(2));
            }
            dapAnEntity.setMaDA(Integer.parseInt(cursor.getString(3)));
            dapAnEntity.setDapAN(cursor.getString(4));
            dapAnEntity.setKiemTra(Boolean.parseBoolean(cursor.getString(5)));
            cauHoiEntity.getDapAnEntities().add(dapAnEntity);

            cursor.moveToNext();
            if (cursor.isAfterLast()) {
                entities.add(cauHoiEntity);
            }
        }
        database.close();
        return entities;
    }
    public List<CauHoiEntity> getBoDe() {
        SQLiteDatabase database = getReadableDatabase();
        int s = 0;
        Cursor cursor = database.rawQuery("SELECT CH.MACH,CH.NOIDUNG,CH.HINHANH,CH.MADAPAN,CH.DAPAN,CH.KIEMTRA  FROM CHITIETDE CTD,(select ch.MACH,ch.NOIDUNG,ch.HINHANH,da.MADAPAN,da.DAPAN,da.KIEMTRA from CAUHOI ch, DAPAN da\n" +
                "where ch.MACH=da.MACH) CH\n" +
                "WHERE CTD.MACH=CH.MACH and CTD.MABODE between 1 and 18", null);
        //List<DapAnEntity> list = new ArrayList<>();
        List<CauHoiEntity> entities = new ArrayList<>();
        CauHoiEntity cauHoiEntity = new CauHoiEntity();
        cursor.moveToFirst();
        s = Integer.parseInt(cursor.getString(0));
        while (!cursor.isAfterLast()) {
            DapAnEntity dapAnEntity = new DapAnEntity();
            if (s != Integer.parseInt(cursor.getString(0))) {
                if (s != 0) {
                    entities.add(cauHoiEntity);
                    cauHoiEntity = new CauHoiEntity();
                    s = Integer.parseInt(cursor.getString(0));
                    cauHoiEntity.setMaCH(Integer.parseInt(cursor.getString(0)));
                    cauHoiEntity.setNoiDung(cursor.getString(1));
                    cauHoiEntity.setHinhAnh(cursor.getString(2));
                }
            } else {
                s = Integer.parseInt(cursor.getString(0));
                cauHoiEntity.setMaCH(Integer.parseInt(cursor.getString(0)));
                cauHoiEntity.setNoiDung(cursor.getString(1));
                cauHoiEntity.setHinhAnh(cursor.getString(2));
            }
            dapAnEntity.setMaDA(Integer.parseInt(cursor.getString(3)));
            dapAnEntity.setDapAN(cursor.getString(4));
            dapAnEntity.setKiemTra(Boolean.parseBoolean(cursor.getString(5)));
            cauHoiEntity.getDapAnEntities().add(dapAnEntity);

            cursor.moveToNext();
            if (cursor.isAfterLast()) {
                entities.add(cauHoiEntity);
            }
        }
        database.close();
        return entities;
    }
}
