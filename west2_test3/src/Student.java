public class Student {
    private int stu_no;
    private String stu_name;
    private int stu_cl;

    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getStu_cl() {
        return stu_cl;
    }

    public void setStu_cl(int stu_cl) {
        this.stu_cl = stu_cl;
    }

    @Override
    public String toString() {
        return  "学号：" + stu_no +
                "---姓名：" + stu_name +
                "---班级编号：" + stu_cl +"\n";
    }
}
