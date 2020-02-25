package com.didispace;

/**
 * description: Test <br>
 * date: 2019/12/31 15:39 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
public class Test {
    private boolean success;
    private Boolean delete;
    private boolean isfail;

    public void testStr() {
        String name1 = "tom";
        String name2 = "hankes";

        String index = "start";
        for (int i = 0; i < 100; i++) {
            index = index + i;
        }
        System.out.println(index);
        String fullName = name1 + name2;

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            buffer.append(i);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append(i);
        }
    }

    public boolean isIsfail() {
        return isfail;
    }

    public void setIsfail(boolean isfail) {
        this.isfail = isfail;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}
