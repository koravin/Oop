import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Binary {

	protected Shell shell;
	private Text text;
	private Button btn_Re;
	private Button btn2To8;
	private Button btn2To16;
	private Button btn_Coming_Home_To_You;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Binary window = new Binary();
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
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(97, 31, 221, 52);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(154, 10, 111, 15);
		label.setText("กรุณากรอกเลขฐาน 2");
		
		//ปุ่มแปลงเลขฐาน 2 ไปเป็นฐาน 10
		Button btn2To10 = new Button(shell, SWT.NONE);
		btn2To10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        boolean isValid = true;//ตัวเปรตรวจสอบว่าค่าที่ผู้ใช้รับเข้ามาเป็น1กับ0หรือไม่ 
		        if(input.isEmpty()){ // เช็คว่าค่า input ว่างหรือไม่
		        	isValid = false;
		        }else{
		        	for(char c : input.toCharArray()){
		        		if(c != '1' && c != '0'){
		        		   isValid = false; // ถ้าค่าที่รับเข้ามาไม่ใช่ 0 กับ 1 และไม่ใช่ค่าว่าง จะถูกเซ็ตเป็น false
		        		   break;
		        		}
		        	}
		        }
		        if(isValid){
		            int decimal = Integer.parseInt(input, 2);//คำสั่งแปลงเลขฐาน2ไปเป็นเลขฐาน10
		            text.setText(Integer.toString(decimal));//แสดงค่าเลขฐาน10ในหน้าจอ
		        }else{
		            text.setText("กรุณาป้อนเลขฐานให้ถูกต้อง");
		        }		        
			}
		});
		btn2To10.setBounds(154, 158, 99, 38);
		btn2To10.setText("2to10");
		
		//ปุ่มเคลียค่าหน้าจอ
		btn_Re = new Button(shell, SWT.NONE);
		btn_Re.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btn_Re.setForeground(SWTResourceManager.getColor(255, 0, 0));
		btn_Re.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	            text.setText("");
			}
		});
		btn_Re.setBounds(35, 108, 99, 38);
		btn_Re.setText("รีรีรี");
		
		//ปุ่มแปลงเลขฐาน 2 ไปเป็นฐาน 8
		btn2To8 = new Button(shell, SWT.NONE);
		btn2To8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        boolean isValid = true;//ตัวเปรตรวจสอบว่าค่าที่ผู้ใช้รับเข้ามาเป็น1กับ0หรือไม่ 
		        if(input.isEmpty()){ // เช็คว่าค่า input ว่างหรือไม่
		        	isValid = false;
		        }else{
		        	for(char c : input.toCharArray()){
		        		if(c != '1' && c != '0'){
		        		   isValid = false; // ถ้าค่าที่รับเข้ามาไม่ใช่ 0 กับ 1 และไม่ใช่ค่าว่าง จะถูกเซ็ตเป็น false
		        		   break;
		        		}
		        	}
		        }
		        if(isValid){
					   input = text.getText();
		               int decimal = Integer.parseInt(input, 2);
		               String octal = Integer.toOctalString(decimal);
		               text.setText(octal);
		        }else{
		            text.setText("กรุณาป้อนเลขฐานให้ถูกต้อง");
		        }
			}
		});
		
		btn2To8.setText("2to8");
		btn2To8.setBounds(35, 158, 99, 38);
		
		//ปุ่มแปลงเลขฐาน 2 ไปเป็นฐาน 16
		btn2To16 = new Button(shell, SWT.NONE);
		btn2To16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        String input = text.getText();
		        boolean isValid = true;//ตัวเปรตรวจสอบว่าค่าที่ผู้ใช้รับเข้ามาเป็น1กับ0หรือไม่ 
		        if(input.isEmpty()){ // เช็คว่าค่า input ว่างหรือไม่
		        	isValid = false;
		        }else{
		        	for(char c : input.toCharArray()){
		        		if(c != '1' && c != '0'){
		        		   isValid = false; // ถ้าค่าที่รับเข้ามาไม่ใช่ 0 กับ 1 และไม่ใช่ค่าว่าง จะถูกเซ็ตเป็น false
		        		   break;
		        		}
		        	}
		        }
		        if(isValid){
					   input = text.getText();
		               int decimal = Integer.parseInt(input, 2);
		               String hex = Integer.toString(decimal, 16);
		               text.setText(hex);
		        }else{
		            text.setText("กรุณาป้อนเลขฐานให้ถูกต้อง");
		        }
			}
		});

		btn2To16.setText("2to16");
		btn2To16.setBounds(279, 158, 99, 38);
		
		//ปุ่มกลับหน้าหลัก
		btn_Coming_Home_To_You = new Button(shell, SWT.NONE);
		btn_Coming_Home_To_You.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        shell.dispose();
		        // Open Practice form
		        Practice practice = new Practice();
		        practice.open();
			}
		});
		btn_Coming_Home_To_You.setBounds(154, 109, 99, 38);
		btn_Coming_Home_To_You.setText("กลับหน้าหลัก");

	}

}
