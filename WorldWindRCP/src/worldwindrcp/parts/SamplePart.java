package worldwindrcp.parts;


import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.awt.WorldWindowGLJPanel;

import javax.swing.*;

public class SamplePart {

	private TableViewer tableViewer;
	
	class SimplestPossibleExample extends JPanel
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SimplestPossibleExample()
	    {
			WorldWindowGLJPanel wwd = new WorldWindowGLJPanel();
	        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
	        //this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
	        wwd.setModel(new BasicModel());
	    }

	}
	@Inject
	private MPart part;
	
    // JButton 
    static JButton b, b1, b2; 
  
    // label to display text 
    static JLabel l; 

	@PostConstruct
	public void createComposite(Composite parent) {
		//parent.setLayout(new GridLayout(1, false));

		/*
		Text txtInput = new Text(parent, SWT.BORDER);
		txtInput.setMessage("Enter text to mark part as dirty");
		txtInput.addModifyListener(e -> part.setDirty(true));
		txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tableViewer = new TableViewer(parent);

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(createInitialDataModel());
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		*/
		
		System.out.println("Gonna do the invoke later");
		
		
        // create a label to display text 
        l = new JLabel("panel label"); 
  
        // create a new buttons 
        b = new JButton("button1"); 
        b1 = new JButton("button2"); 
        b2 = new JButton("button3"); 
  
        // create a panel to add buttons 
        JPanel p = new JPanel(); 
  
        // add buttons and textfield to panel 
        p.add(b); 
        p.add(b1); 
        p.add(b2); 
        p.add(l); 
  
        // setbackground of panel 
        p.setBackground(Color.red); 

		
		// Setup AWT container.
		Composite embeddedContainer = new Composite(parent, SWT.EMBEDDED);
		java.awt.Frame containerFrame = SWT_AWT.new_Frame(embeddedContainer);
		//java.awt.Panel panel = new java.awt.Panel(new java.awt.BorderLayout());
		//frame.add(panel);
		containerFrame.add(p);
		
	    JApplet applet = new JApplet();
	    containerFrame.add(applet);
	      

		
		// Create World Wind canvas and add it to panel.
		/*
		WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
		wwd.setModel(new BasicModel());
		panel.add(wwd, java.awt.BorderLayout.CENTER);
        */
		
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
        		System.out.println("Insider run");
        		JPanel panel = new SimplestPossibleExample();
        		
    			WorldWindowGLJPanel wwd = new WorldWindowGLJPanel();
    	        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
    	        //this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
    	        wwd.setModel(new BasicModel());
    	        containerFrame.add(wwd);
        		
                //panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //panel.pack();                
                //containerFrame.add(panel);
                //containerFrame.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);

                //applet.add(panel);
                //frame.setVisible(true);
            }
        });
		
	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

	@Persist
	public void save() {
		part.setDirty(false);
	}
	
	private List<String> createInitialDataModel() {
		return Arrays.asList("Sample item 1", "Sample item 2", "Sample item 3", "Sample item 4", "Sample item 5");
	}
}