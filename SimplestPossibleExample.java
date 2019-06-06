/*
 * Copyright (C) 2012 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.Configuration;

import javax.swing.*;

/**
 * This example demonstrates the simplest possible way to create a WorldWind application.
 *
 * @version $Id: SimplestPossibleExample.java 1171 2013-02-11 21:45:02Z dcollins $
 */
public class SimplestPossibleExample extends JFrame
{
    public SimplestPossibleExample()
    {
		String foobar = Configuration.getUserHomeDirectory();
		String current = Configuration.getCurrentWorkingDirectory();
		boolean isWin = Configuration.isWindowsOS();

		String KEYVALUE = Configuration.getStringValue("gov.nasa.worldwind.avkey.MilStd2525IconRetrieverPath");

		System.out.println(foobar);
		System.out.println(isWin);
		System.out.println(current);
		System.out.println(KEYVALUE);
		
        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new SimplestPossibleExample();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
