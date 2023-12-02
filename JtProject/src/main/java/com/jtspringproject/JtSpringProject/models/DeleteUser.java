/*
// @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
// public String deleteUser(@RequestParam("userid") int userid) {
//     try {
//         Class.forName("com.mysql.jdbc.Driver");
//         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommjava", "root", "");

//         PreparedStatement pst = con.prepareStatement("delete from users where uid = ?");
//         pst.setInt(1, userid);
//         int i = pst.executeUpdate();
//     } catch (Exception e) {
//         System.out.println("Exception:" + e);
//     }
//     return "redirect:/index";
// }

// @RequestMapping(value = "updateuser",method=RequestMethod.POST)
// 	public String updateUserProfile(@RequestParam("userid") int userid,@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("address") String address) 
	
// 	{
// 		try
// 		{
// 			Class.forName("com.mysql.jdbc.Driver");
// 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommjava","root","");
			
// 			PreparedStatement pst = con.prepareStatement("update users set username= ?,email = ?,password= ?, address= ? where uid = ?;");
// 			pst.setString(1, username);
// 			pst.setString(2, email);
// 			pst.setString(3, password);
// 			pst.setString(4, address);
// 			pst.setInt(5, userid);
// 			int i = pst.executeUpdate();	
// 			usernameforclass = username;
// 		}
// 		catch(Exception e)
// 		{
// 			System.out.println("Exception:"+e);
// 		}
// 		return "redirect:/index";
// 	}

//      // Set up GUI
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(400, 300);

//         JPanel panel = new JPanel(new BorderLayout());
//         panel.add(new JScrollPane(customerList), BorderLayout.CENTER);

//         JPanel buttonPanel = new JPanel(new FlowLayout());
//         buttonPanel.add(deleteButton);
//         buttonPanel.add(updateButton);

//         panel.add(buttonPanel, BorderLayout.SOUTH);

//         add(panel);

//         // Event listeners
//         deleteButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 int selectedIndex = customerList.getSelectedIndex();
//                 if (selectedIndex != -1) {
//                     listModel.remove(selectedIndex);
//                 }
//             }
//         });

//         updateButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 int selectedIndex = customerList.getSelectedIndex();
//                 if (selectedIndex != -1) {
//                     // Assuming you have a dialog for updating customer information
//                     updateCustomerInformation(selectedIndex);
//                 }
//             }
//         });
//     }


@Controller
public class UserController {

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("userid") int userid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommjava", "root", "");

            PreparedStatement pst = con.prepareStatement("delete from users where uid = ?");
            pst.setInt(1, userid);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUserProfile(@RequestParam("userid") int userid,
                                    @RequestParam("username") String username,
                                    @RequestParam("email") String email,
                                    @RequestParam("password") String password,
                                    @RequestParam("address") String address) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommjava", "root", "");

            PreparedStatement pst = con.prepareStatement("update users set username = ?, email = ?, password = ?, address = ? where uid = ?");
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, address);
            pst.setInt(5, userid);
            int i = pst.executeUpdate();
            // Additional logic as needed
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
        return "redirect:/index";
    }
}
*/

