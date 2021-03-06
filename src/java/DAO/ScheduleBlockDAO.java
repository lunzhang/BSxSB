/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.HibernateUtil;
import Mapping.POJO.Scheduleblocks;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alvin
 */
public class ScheduleBlockDAO {

    private static Session session;

    public static List<Scheduleblocks> getSchoolsScheduleBlocks(int schoolid) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Query query = session.createSQLQuery(
                "SELECT * FROM scheduleblocks WHERE scheduleblocks.schoolid = ?")
                .addEntity(Scheduleblocks.class)
                .setInteger(0, schoolid);
        List<Scheduleblocks> schoolScheduleBlocks = query.list();
        session.getTransaction().commit();
        return schoolScheduleBlocks;
    }

    public static Scheduleblocks getScheduleBlock(int scheduleBlockID) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createSQLQuery(
                "SELECT * FROM scheduleblocks WHERE scheduleblockid = ?")
                .addEntity(Scheduleblocks.class)
                .setInteger(0, scheduleBlockID);
        List<Scheduleblocks> schoolScheduleBlocks = query.list();
        session.getTransaction().commit();
        if (schoolScheduleBlocks.isEmpty()) {
            return null;
        } else {
            return schoolScheduleBlocks.get(0);
        }
    }

    public static Scheduleblocks getScheduleBlock(int schoolid, int period, String days) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createSQLQuery("SELECT * FROM scheduleblocks WHERE schoolid = ? AND period = ? AND days = ?")
                .addEntity(Scheduleblocks.class)
                .setInteger(0, schoolid)
                .setInteger(1, period)
                .setParameter(2, days);
        List<Scheduleblocks> sb = query.list();
        session.getTransaction().commit();
        if (sb.isEmpty()) {
            return null;
        } else {
            return sb.get(0);
        }
    }

    public static void addScheduleBlock(int schoolID, int periods, String days) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        Scheduleblocks sb = new Scheduleblocks();
        sb.setDays(days);
        sb.setPeriod(periods);
        sb.setSchoolid(schoolID);
        session.save(sb);

        session.getTransaction().commit();
    }

    public static void deleteSchoolScheduleBlocks(int schoolid) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        Query query = session.createSQLQuery(
                "SELECT * FROM scheduleblocks WHERE scheduleblocks.schoolid = ?")
                .addEntity(Scheduleblocks.class)
                .setInteger(0, schoolid);
        List<Scheduleblocks> schoolScheduleBlocks = query.list();
        for (Scheduleblocks s : schoolScheduleBlocks) {
            session.delete(s);
        }

        session.getTransaction().commit();
    }

    public static void deleteScheduleBlock(int scheduleblockID) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        Scheduleblocks sb = (Scheduleblocks) session.get(Scheduleblocks.class, scheduleblockID);
        session.delete(sb);

        session.getTransaction().commit();
    }
}
