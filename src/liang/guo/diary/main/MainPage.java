package liang.guo.diary.main;


import java.awt.Font;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import liang.guo.diary.util.BackgroundPanel;


/**
 * @author  XFHY
 * @date  2016年11月30日 下午10:31:06
 * @package liang.guo.diary.main
 * @function 主界面    当用户登录成功就显示这个界面
 * 可以写日记,系统设置,查找日记等等
 */
public class MainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8742469121530688625L;

	/**
	 * 主菜单栏
	 */
	JMenuBar mainMenuBar = new JMenuBar();   
	JMenu systemSettingsMenu = new JMenu("系统设置");
	JMenu diaryManagementMenu = new JMenu("日记管理");
	JMenu otherMenu = new JMenu("其他");
	JMenuItem keepDiaryMenuItem = new JMenuItem("写日记");
	JMenuItem seeDiaryMenuItem = new JMenuItem("查找日记");
	JMenuItem exitMenuItem = new JMenuItem("退出");
	JMenuItem logoffMenuItem = new JMenuItem("注销");
	
	/**
	 * 背景
	 */
	BackgroundPanel mainBackGround;
	
	/**
	 * 构造函数
	 */
	public MainPage(){
		init();
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		initAllMenu();   //初始化所有菜单
		
		//"image/main/主界面背景.jpg"
		mainBackGround = new BackgroundPanel(new ImageIcon("image/main/主界面背景.jpg").getImage());
		this.getContentPane().add(mainBackGround);   //添加背景 布局
		
		this.setJMenuBar(mainMenuBar);   //设置菜单栏
		this.setSize(751, 481);    
	}
	
	/**
	 * 初始化所有菜单
	 */
	public void initAllMenu(){
		keepDiaryMenuItem.setIcon(new ImageIcon("image/main/写日记.png"));
		seeDiaryMenuItem.setIcon(new ImageIcon("image/main/查找.png"));
		exitMenuItem.setIcon(new ImageIcon("image/main/退出.png"));
		logoffMenuItem.setIcon(new ImageIcon("image/main/注销.png"));
		
		//日记管理菜单
		diaryManagementMenu.add(keepDiaryMenuItem);
		diaryManagementMenu.add(seeDiaryMenuItem);
		
		//其他菜单
		otherMenu.add(exitMenuItem);
		otherMenu.add(logoffMenuItem);
		
		//主菜单
		mainMenuBar.add(systemSettingsMenu);
		mainMenuBar.add(diaryManagementMenu);
		mainMenuBar.add(otherMenu);
	}
	
	/**
	 * 显示UI
	 */
	public void showUI(){
		this.setLocationRelativeTo(null);    //设置JFrame居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);  //设置JFrame可见
	}
	
	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args) {
		InitGlobalFont(new Font(Font.SANS_SERIF,Font.PLAIN,15));  
        try {  
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();  
            
            //这句是更换主题
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.
            		FrameBorderStyle.generalNoTranslucencyShadow;  
            
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();  
            UIManager.put("RootPane.setupButtonVisible", false);  
            //BeautyEyeLNFHelper.translucencyAtFrameInactive = false;  
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        } catch (Exception e) {  
            System.err.println("set skin fail!");  
        }  
		
		new MainPage().showUI();
	}

	/**
	 * 初始化字体
	 * @param font
	 */
	private static void InitGlobalFont(Font font) {  
        FontUIResource fontRes = new FontUIResource(font);  
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {  
            Object key = keys.nextElement();  
            Object value = UIManager.get(key);  
            if (value instanceof FontUIResource) {  
                UIManager.put(key, fontRes);  
            }  
        }  
    }  
	
}