package cn.i623.alpha.javafxdemo.test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cn.i623.alpha.javafxdemo.util.ExcelUtils.getCellFormatValue;
import static cn.i623.alpha.javafxdemo.util.ExcelUtils.readExcel;

public class IDCard {
    //字段
    String city;
    String birthday;
    int num;
    String check;
    Boolean isMan;//奇数

    //构造器
    public IDCard(IDCardBulider idCardBulider) {
        this.city = idCardBulider.city;
        this.birthday = idCardBulider.birthday;
        this.num = idCardBulider.num;
        this.check = idCardBulider.check;
        this.isMan = idCardBulider.isMan;
    }

    //测试
    public static void main(String[] args) throws IOException {
        IDCard idCard = new IDCardBulider(false)
                .city(null)
                .birthday("19970623").num(-2).check("").bulid();
        String id = idCard.getId();
        System.out.println(id);

    }

    //校验算法
    private static Integer getWi(int i) {
        assert i > 0;
        double pow = Math.pow(2, --i);
        return (int) pow % 11;
    }

    public String getId() {
        return (num == -1 || check == null) ? null : city + birthday + num + check;
    }


    //静态内部类，构建者
    public static class IDCardBulider {
        String city;
        String birthday;
        int num;
        String check;
        Boolean isMan;//奇数

        public IDCardBulider(Boolean isMan) {
            this.isMan = isMan;
        }

        //方法
        public static List<String> findTopList() {
            List<String> tl = new ArrayList<>();
            //创建工作簿
            String pathname = "C:\\Users\\28442\\Desktop\\区号.xlsx";
            Workbook sheets = readExcel(pathname);
            Sheet sheet = sheets.getSheetAt(0); //sheet
//        Print.p("sheet",sheet.getRow());
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                String tempsnFormat = (String) getCellFormatValue(row.getCell(0));
                String tempsnFormat2 = (String) getCellFormatValue(row.getCell(1));
//            Print.p(tempsnFormat);
                if (tempsnFormat != null && tempsnFormat.trim().length() > 0) {
                    tl.add(tempsnFormat);
                }
//            Print.p(tempsnFormat2.trim());
            }
            return tl;
        }

        public IDCardBulider city(String city) {
            if (city == null) {
                List<String> topList = findTopList();
                int ridx = (int) (Math.random() * topList.size());
                System.out.println(ridx);
                city = topList.get(ridx);
//                System.out.println();
            }
            this.city = city;
            return this;
        }

        public IDCardBulider birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public IDCardBulider num(int num) {
            this.num = this.isMan ^ num % 2 == 0 ? num : -1;
            return this;
        }

        public IDCard bulid() {

            return new IDCard(this);
        }

        public IDCardBulider check(String check) {
            if (this.num > -1) {
                String[] checkArray = new String[11];
                for (int j = 0; j < 10; j++) {
                    checkArray[j] = String.valueOf(j);
                }
                checkArray[10] = "Ⅹ";
                for (String c : checkArray) {
                    int valueCount = 0;
                    String id = this.city + this.birthday + this.num + c;
                    for (int i = 0; i < id.length(); i++) {
                        int rIdx = 18 - i;
                        int curNum;
                        try {
                            curNum = Integer.parseInt(id.substring(i, i + 1));
                        } catch (NumberFormatException e) {
                            curNum = 10;
                        }
                        Integer Widx = getWi(rIdx);
                        int value = curNum * Widx;
                        valueCount += value;
                    }
                    if (valueCount % 11 == 1) {
                        this.check = c;
                        return this;
                    }
                }

            } else if (num == -2) {

            }
            return this;
        }

    }

}
