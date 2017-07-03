// Copyright - Znalytics (http://www.Znalytics.com/)

package com.znalytics.framework.core;

import java.util.ArrayList;
import java.util.logging.Level;

import com.znalytics.enrollment.tx.api.tests.Enrollment;
import com.znalytics.framework.maintenance.Backup;
import com.znalytics.framework.report.ProcessReport;
import com.znalytics.productmanagement.tests.ProductManagement;

/**
 * The Class TestModules.
 *
 * @author: Nikesh Jauhari
 * @mail: najuahri@znalytics.com
 * @date: Mar 11, 2015
 */
public class TestModules {

	/** The modules. */
	private String modules;

	/** The video. */
	private RecordVideo video;

	/** The Record video. */
	private boolean RecordVideo = false;

	/**
	 * Instantiates a new test modules.
	 *
	 * @param modules
	 *            the modules
	 */
	public TestModules(String modules) {
		this.modules = modules;
		if (DataSource.globalConfig.get("record.video").equalsIgnoreCase("yes")) {
			this.RecordVideo = true;
		}
	}

	/**
	 * Execute modules.
	 */
	public void executeModules() {
		Constants.TESTRESULTS = new ArrayList<String>();
		DataSource.report.clear();
		Setup.reInitialize();
		Backup backUP = new Backup();
		SendMail sendMail = new SendMail();
		this.modules = this.modules.toLowerCase();
		Timer timer = new Timer();
		switch (this.modules) {
		case "enrollment":
			Enrollment en = null;
			try {
				startVideoRecording();
				timer.start();
				en = new Enrollment();
				en.loadData();
				timer.end();
				Logs.LOGGER.info("Total time taken: " + timer.getTotalTime());
			} catch (Exception e) {
				Logs.LOGGER.log(Level.SEVERE, "", e);
			} finally {
				Logs.LOGGER.info("Cleaning up the memory.");
				stopVideoRecording();
				if (null != en) {
					Enrollment.app.clear();
					Enrollment.css.clear();
				}
				if (Constants.DRIVERINIT) {
					Setup.getInstance().getDriver().quit();
				}
				sendMail.sendStatusMail(ProcessReport.ProcessReportData());
				backUP.backupReports();
			}
			break;
		case "productmanagement":
			ProductManagement pm = null;
			try {
				startVideoRecording();
				timer.start();
				pm = new ProductManagement();
				pm.loadData();
				timer.end();
				Logs.LOGGER.info("Total time taken: " + timer.getTotalTime());
			} catch (Exception e) {
				Logs.LOGGER.log(Level.SEVERE, "", e);
			} finally {
				Logs.LOGGER.info("Cleaning up the memory.");
				stopVideoRecording();
				if (null != pm) {
					ProductManagement.app.clear();
					ProductManagement.css.clear();
				}
				if (Constants.DRIVERINIT) {
					Setup.getInstance().getDriver().quit();
				}
				sendMail.sendStatusMail(ProcessReport.ProcessReportData());
				backUP.backupReports();
			}
			break;
			
		
		default:
			Logs.LOGGER.severe("Invalid Module, please check the config file.");
			break;

		}
	}

	/**
	 * Start video recording.
	 */
	private void startVideoRecording() {
		if (this.RecordVideo) {
			video = new RecordVideo();
			video.startVideoRecording();
		} else {
			Logs.LOGGER.info("No Video Recording required.");
		}
	}

	/**
	 * Stop video recording.
	 */
	private void stopVideoRecording() {
		if (this.RecordVideo) {
			video.stopVideoRecording();
		}
	}

}
