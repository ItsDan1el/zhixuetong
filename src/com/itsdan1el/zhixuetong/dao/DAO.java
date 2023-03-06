package com.itsdan1el.zhixuetong.dao;

import java.util.Date;


import com.itsdan1el.zhixuetong.pojo.User;

public interface DAO {

    public void deleteEmp(Integer id);

    public void addCLockInRecord(int empID, Date now);

    /**
     * ɾ��ָ��Ա�����д򿨼�¼
     *
     * @param empID Ա�����
     */
    public void deleteClockInRecord(int empID);

    /**
     * ��ȡ����Ա���Ĵ򿨼�¼
     *
     * @return ��������¼Ա����ţ���������¼������
     */
    public String[][] getAllClockInRecord();

    /**
     * ��֤����Ա��¼
     *
     * @param user ����Ա�˺�
     * @return ����˺�������ȷ���򷵻�true�����򷵻�false
     */
    static boolean userLogin(User user) {
        return false;
    }
}
