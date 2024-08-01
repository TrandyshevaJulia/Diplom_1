package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = new Bun("white bun", 200);
        ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 50);
        ingredient3 = new Ingredient(IngredientType.FILLING, "lettuce", 20);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 2);
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(ingredient2, ingredients.get(0)); // Проверяем, что на индексе 0 теперь находится ingredient2.
        assertEquals(ingredient3, ingredients.get(1)); // Проверяем, что на индексе 1 теперь находится ingredient3.
        assertEquals(ingredient1, ingredients.get(2)); // Проверяем, что на индексе 2 теперь находится ingredient1.
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1); // Удаляем второй ингредиент (sour cream)
        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(2, ingredients.size()); // Проверяем, что в списке осталось 2 ингредиента.
        assertEquals(ingredient1, ingredients.get(0)); // Проверяем, что на индексе 0 остался ingredient1.
        assertEquals(ingredient3, ingredients.get(1)); // Проверяем, что на индексе 1 теперь находится ingredient3.
    }
}