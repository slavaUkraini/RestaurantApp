

package DBofrestaurant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @angelika 
 */
public class Food {
        private static final String DB_NAME = "sqlite";
	private static final String DB_FILE_NAME = "restaurant.db";
	private static final String DB = "org.sqlite.JDBC";

	private static final String TABLE_NAME = "MENU";

	private static final String NAME_COLUMN = "NAME";
	private static final String CATEGORY_COLUMN = "CATEGORY";
	private static final String PRICE_COLUMN = "PRICE";
	private static final String COMPOUND_COLUMN = "COMPOUND";
        
        public Food() {
            
		initialization();
	}

	/**
	 * 
	 * @param categorie
	 * @return
	 */
	public Iterable<FoodData> getFood(String categorie) {
		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT `" + NAME_COLUMN +"`, `"+COMPOUND_COLUMN+""
					+ "` FROM " + TABLE_NAME + " WHERE `" + CATEGORY_COLUMN
					+ "`='" + categorie + "'");

			List<FoodData> result = convertResultSetToFoodList(resultSet);

			connection.close();

			return result;
                            } catch (SQLException e1) {
                            e1.printStackTrace();
                            }

                    return Collections.emptyList();
                    }
                public String[] getAllCategories() {
		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT `"+CATEGORY_COLUMN+"` FROM "
					+ TABLE_NAME);

			String[] result = convertResultSetToCategoryArray(resultSet);

			connection.close();

			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return new String[0];
	}

                public Iterable<FoodData> searchDish(String name) {

		Connection connection = getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM " + TABLE_NAME+" WHERE `"+NAME_COLUMN+"`='"+name+"'");

			List<FoodData> result = convertResultSetToNameList(resultSet);

			connection.close();

			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return Collections.emptyList();
	}
        
         public static void main(String[] args) {
       Food f = new Food();
      
       for (FoodData worker : f.searchDish("Піца з куркою")) {//які категорії?
            System.out.println(worker);
            }
          }
            private List<FoodData> convertResultSetToNameList(ResultSet resultSet) {
		List<FoodData> list = new ArrayList<FoodData>();

		try {
			while (resultSet.next()) {
                                FoodData food = new FoodData(resultSet.getString(NAME_COLUMN), resultSet.getString(CATEGORY_COLUMN), resultSet.getString(COMPOUND_COLUMN), resultSet.getDouble(PRICE_COLUMN));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param resultSet
	 * @return
	 */
	private String[] convertResultSetToCategoryArray(ResultSet resultSet) {
		Set<String> list = new TreeSet<String>();

		try {
			while (resultSet.next()) {
				list.add(resultSet.getObject(1) + "");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return convertListToArray(list);
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private String[] convertListToArray(Set<String> list) {
		String[] array = new String[list.size()];
		int index = 0;
		for (String string : list) {
			array[index] = string;
			index++;
		}
		return array;
	}

	/**
	 * 
	 * @param resultSet
	 * @return
	 */
	private List<FoodData> convertResultSetToFoodList(ResultSet resultSet) {
		List<FoodData> list = new ArrayList<FoodData>();
		try {
			while (resultSet.next()) {
				FoodData food=new FoodData();
				food.setCategory(resultSet.getString(NAME_COLUMN));
				food.setCompound(resultSet.getString(COMPOUND_COLUMN));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
        
       private void initialization() {
		try {
			Connection con = getConnection();
			PreparedStatement work = con
					.prepareStatement("create table if not exists 'MENU' ('Id' INTEGER PRIMARY KEY UNIQUE, '"
							+ CATEGORY_COLUMN
							+ "' text, '"
							+ NAME_COLUMN
							+ "' text UNIQUE, '"
							+ COMPOUND_COLUMN
							+ "' text, '" + PRICE_COLUMN + "' REAL);");
			work.executeUpdate();

			work.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("�� ����� SQL �����");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	private Connection getConnection() {
		try {
			Class.forName(DB);
			Connection connection = DriverManager.getConnection(String.format(
					"jdbc:%s:%s", DB_NAME, DB_FILE_NAME));
			return connection;
		} catch (SQLException e) {
			System.err.println(DB);
			System.err.println(String.format("jdbc:%s:%s", DB_NAME,
					DB_FILE_NAME));
			return null;
		}catch(ClassNotFoundException e){
                    return null;
                }
	}
        
        public class FoodData{
		
		private String name;
		private String category;
		private String compound;
		private double price;
		public FoodData(String name, String category, String compound,
				double price) {
			super();
			this.name = name;
			this.category = category;
			this.compound = compound;
			this.price = price;
		}
		
		public FoodData(){
			
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getCompound() {
			return compound;
		}
		public void setCompound(String compound) {
			this.compound = compound;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		@Override
		public String toString() {
			return "FoodData [name=" + name + ", category=" + category
					+ ", compound=" + compound + ", price=" + price + "]";
		}
	}

}




