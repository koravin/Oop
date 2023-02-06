import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Practice {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Practice window = new Practice();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("Segoe UI", 19, SWT.BOLD | SWT.ITALIC));
		label.setBounds(80, 21, 272, 38);
		label.setText("โปรแกรมแปลงเลขฐาน");
		
		//ปุ่มแปลงเลขฐาน 2
		Button Button_Binary = new Button(shell, SWT.NONE);
		Button_Binary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        // Close current form
		        shell.dispose();
		        // Open Binary form
		        Binary binary = new Binary();
		        binary.open();


			}
		});
		Button_Binary.setBounds(80, 81, 74, 31);
		Button_Binary.setText("แปลงเลขฐาน 2");
		
		
		//ปุ่มแปลงเลขฐาน 8
		Button Button_Octal = new Button(shell, SWT.NONE);
		Button_Octal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        // Close current form
		        shell.dispose();
		        // Open Octal form
		        Octal octal = new Octal();
		        octal.open();
			}
		});
		
		Button_Octal.setText("แปลงเลขฐาน 8");
		Button_Octal.setBounds(188, 81, 74, 31);
		
		
		//ปุ่มแปลงเลขฐาน 10
		Button Button_Decimal = new Button(shell, SWT.NONE);
		Button_Decimal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        // Close current form
		        shell.dispose();
		        // Open Octal form
		        Decimal decimal = new Decimal();
		        decimal.open();
				
			}
		});
		Button_Decimal.setText("แปลงเลขฐาน 10");
		Button_Decimal.setBounds(291, 81, 85, 31);
		
		
		//ปุ่มแปลงเลขฐาน 16
		Button Button_Hex = new Button(shell, SWT.NONE);
		Button_Hex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        // Close current form
		        shell.dispose();
		        // Open Hex form
		        Hex hex = new Hex();
		        hex.open();
			}
		});
		
		//ปุ่ม Random Number
		Button_Hex.setText("แปลงเลขฐาน 16");
		Button_Hex.setBounds(80, 137, 85, 31);
		
		Button Button_Random = new Button(shell, SWT.NONE);
		Button_Random.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        // Close current form
		        shell.dispose();
		        // Random Number form
		        RandomNumber randomnumber = new RandomNumber();
		        randomnumber.open();
			}
		});
		Button_Random.setText("สุ่ม");
		Button_Random.setBounds(188, 137, 74, 31);

	}
}
