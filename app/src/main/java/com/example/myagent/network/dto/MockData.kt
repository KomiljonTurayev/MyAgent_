package com.example.myagent.network.dto

import com.example.myagent.R

class MockData {

    companion object {


        fun getProductCategoryDataList(): List<ProductCategoryData> {
            val list = ArrayList<ProductCategoryData>()

            list.add(ProductCategoryData(R.drawable.bread, "Хлебокондитерская"))
            list.add(ProductCategoryData(R.drawable.wine, "Вино-водочный"))
            list.add(ProductCategoryData(R.drawable.banana, "Овощи и фрукты"))
            list.add(ProductCategoryData(R.drawable.cansetver, "Bonduelle резаные"))
            list.add(ProductCategoryData(R.drawable.bread, "Хлебокондитерская"))
            list.add(ProductCategoryData(R.drawable.wine, "Вино-водочный"))
            list.add(ProductCategoryData(R.drawable.banana, "Овощи и фрукты"))
            list.add(ProductCategoryData(R.drawable.cansetver, "Bonduelle резаные"))
            list.add(ProductCategoryData(R.drawable.bread, "Хлебокондитерская"))
            list.add(ProductCategoryData(R.drawable.wine, "Вино-водочный"))
            list.add(ProductCategoryData(R.drawable.banana, "Овощи и фрукты"))
            list.add(ProductCategoryData(R.drawable.cansetver, "Bonduelle резаные"))

            return list
        }


        fun getBastketList(): ArrayList<BasketData> {

            val list = ArrayList<BasketData>()

            list.add(
                BasketData(
                    R.drawable.basket_image, "Шампиньоны\n" +
                            "Bonduelle резаные1", "Неизменно качественные,\n" +
                            "отборные «молодые»\n" +
                            "шампиньоны собраны...", "ООО «Bonduelle»", "55 220 сум"
                )
            )
            list.add(
                BasketData(
                    R.drawable.basket_image, "Шампиньоны\n" +
                            "Bonduelle резаные2", "Неизменно качественные,\n" +
                            "отборные «молодые»\n" +
                            "шампиньоны собраны...", "ООО «Bonduelle»", "55 220 сум"
                )
            )
            list.add(
                BasketData(
                    R.drawable.basket_image, "Шампиньоны\n" +
                            "Bonduelle резаные3", "Неизменно качественные,\n" +
                            "отборные «молодые»\n" +
                            "шампиньоны собраны...", "ООО «Bonduelle»", "55 220 сум"
                )
            )
            list.add(
                BasketData(
                    R.drawable.basket_image, "Шампиньоны\n" +
                            "Bonduelle резаные4", "Неизменно качественные,\n" +
                            "отборные «молодые»\n" +
                            "шампиньоны собраны...", "ООО «Bonduelle»", "55 220 сум"
                )
            )

            return list
        }

        fun getWineDataList(): List<WineData> {
            var list = ArrayList<WineData>()

            list.add(WineData(R.drawable.wine, "Вино"))
            list.add(WineData(R.drawable.wine1, "Пиво"))
            list.add(WineData(R.drawable.wine2, "Вино"))
            list.add(WineData(R.drawable.wine3, "Водка"))
            list.add(WineData(R.drawable.wine4, "Джин"))
            list.add(WineData(R.drawable.wine5, "Виски"))
            list.add(WineData(R.drawable.wine6, "Ром"))
            list.add(WineData(R.drawable.wine, "Вино"))

            return list
        }

        fun getSuppliersDataList(): List<SuppliersData> {
            val list = ArrayList<SuppliersData>()

            list.add(SuppliersData("Xoshmatov Ibragim", "ИП «Оливковое поле»"))
            list.add(SuppliersData("Mirzakov Islom", "ИП «Магаз»"))
            list.add(SuppliersData("Nazarhan Sevara", "ИП «Телеком Марказ»"))
            list.add(SuppliersData("Boyarishnikov Nikolay", "ИП «Смартер»"))
            list.add(SuppliersData("Xoshmatov Ibragim", "ИП «Оливковое поле»"))
            list.add(SuppliersData("Mirzakov Islom", "ИП «Магаз»"))
            list.add(SuppliersData("Nazarhan Sevara", "ИП «Телеком Марказ»"))
            list.add(SuppliersData("Boyarishnikov Nikolay", "ИП «Смартер»"))
            list.add(SuppliersData("Xoshmatov Ibragim", "ИП «Оливковое поле»"))
            list.add(SuppliersData("Mirzakov Islom", "ИП «Магаз»"))
            list.add(SuppliersData("Nazarhan Sevara", "ИП «Телеком Марказ»"))
            list.add(SuppliersData("Boyarishnikov Nikolay", "ИП «Смартер»"))
            list.add(SuppliersData("Xoshmatov Ibragim", "ИП «Оливковое поле»"))
            list.add(SuppliersData("Mirzakov Islom", "ИП «Магаз»"))
            list.add(SuppliersData("Nazarhan Sevara", "ИП «Телеком Марказ»"))
            list.add(SuppliersData("Boyarishnikov Nikolay", "ИП «Смартер»"))

            return list

        }
        fun getAllProducts():ArrayList<AllProducts>{
            val list=ArrayList<AllProducts>()
            list.add(AllProducts(R.drawable.photo_product_1,"Оливки зеленые без косточек","Молодые ягоды оливкового дерева тщатель отбираются по цвету и размеру...","ИП «Оливковое поле»","39 000 сум","New",1,0))
            list.add(    AllProducts(R.drawable.bonduel,"Шампиньоны Bonduelle резаные","Неизменно качественные, отборные «молодые» шампиньоны собраны...","ООО «Bonduelle»","55 220 сум","New",1,0))
            list.add(AllProducts(R.drawable.photo_product_1,"Оливки зеленые без косточек","Молодые ягоды оливкового дерева тщатель отбираются по цвету и размеру...","ИП «Оливковое поле»","39 000 сум","New",1,0))
            list.add(AllProducts(R.drawable.photo_product_1,"Оливки зеленые без косточек","Молодые ягоды оливкового дерева тщатель отбираются по цвету и размеру...","ИП «Оливковое поле»","39 000 сум","New",1,0))
            list.add(AllProducts(R.drawable.bonduel,"Шампиньоны Bonduelle резаные","Неизменно качественные, отборные «молодые» шампиньоны собраны...","ООО «Bonduelle»","55 220 сум","New",1,0))

            return list
        }
        fun getSuppliersList():List<SupplierListOfData>{
            return listOf<SupplierListOfData>(SupplierListOfData("Xoshmatov Ibragim", "ИП «Оливковое поле»"),
                SupplierListOfData("Mirzakov Islom","ИП «Магаз»"),
                SupplierListOfData("Mirzakov Islom","ИП «Магаз»"),
                SupplierListOfData("Nazarhan Sevara","ИП «Телеком Марказ»"),
                SupplierListOfData("Boyarishnikov Nikolay","ИП «Смартер»")
            )
        }
        fun getQuestionAnswer():List<QuestionAnswerData>{
            return listOf<QuestionAnswerData>(QuestionAnswerData("Как сделать заказ и как его отменить","Цитата как бы придвигает к нам прошлое, при этом расположение эпизодов отражает эпизодический размер, особенно подробно рассмотрены трудности, с которыми сталкивалась женщина крестьянка в 19 веке. Аллюзия фонетически вызывает стих, поэтому никого не удивляет, что в финале порок наказан. Декодирование представляет собой прозаический парафраз."),
                QuestionAnswerData("Как сменить язык приложения","Цитата как бы придвигает к нам прошлое, при этом расположение эпизодов отражает эпизодический размер, особенно подробно рассмотрены трудности, с которыми сталкивалась женщина крестьянка в 19 веке. Аллюзия фонетически вызывает стих, поэтому никого не удивляет, что в финале порок наказан. Декодирование представляет собой прозаический парафраз."),
                QuestionAnswerData("Как получить информацию","Цитата как бы придвигает к нам прошлое, при этом расположение эпизодов отражает эпизодический размер, особенно подробно рассмотрены трудности, с которыми сталкивалась женщина крестьянка в 19 веке. Аллюзия фонетически вызывает стих, поэтому никого не удивляет, что в финале порок наказан. Декодирование представляет собой прозаический парафраз."),
                QuestionAnswerData("Как отменить заказ","Цитата как бы придвигает к нам прошлое, при этом расположение эпизодов отражает эпизодический размер, особенно подробно рассмотрены трудности, с которыми сталкивалась женщина крестьянка в 19 веке. Аллюзия фонетически вызывает стих, поэтому никого не удивляет, что в финале порок наказан. Декодирование представляет собой прозаический парафраз."),
                QuestionAnswerData("Как зарегистрировать товар","Цитата как бы придвигает к нам прошлое, при этом расположение эпизодов отражает эпизодический размер, особенно подробно рассмотрены трудности, с которыми сталкивалась женщина крестьянка в 19 веке. Аллюзия фонетически вызывает стих, поэтому никого не удивляет, что в финале порок наказан. Декодирование представляет собой прозаический парафраз."),
                QuestionAnswerData("Как найти поставщика","Цитата как бы придвигает к нам прошлое, при этом расположение эпизодов отражает эпизодический размер, особенно подробно рассмотрены трудности, с которыми сталкивалась женщина крестьянка в 19 веке. Аллюзия фонетически вызывает стих, поэтому никого не удивляет, что в финале порок наказан. Декодирование представляет собой прозаический парафраз."))

        }
        fun getHowDoesItWork():List<HowDoesItWorkData>{
            return listOf<HowDoesItWorkData>(HowDoesItWorkData("Как сделать заказ и как его отменить"),
                HowDoesItWorkData("Как сменить язык приложения"),
                HowDoesItWorkData("Как сменить язык приложения"),
                HowDoesItWorkData("Как сменить язык приложения"),
                HowDoesItWorkData("Как сменить язык приложения"),
                HowDoesItWorkData("Как сменить язык приложения")
            )
        }


        fun getOrderHistoryDataList(): List<OrderHistoryData> {
            val item = ArrayList<Item>()
            val item2 = ArrayList<Item>()

            item.add(
                Item(
                    R.drawable.wine, "30 шт", "Оливки зеленые без\n" +
                            "косточек", "225 000 сум"
                )
            )
            item.add(
                Item(
                    R.drawable.wine1, "20 шт", "Шампиньоны Bonduelle\n" +
                            "резаные", "89 000 сум"
                )
            )
            item.add(Item(R.drawable.wine2, "5 шт", "Томаты Pomato очищенные", "55 000 сум"))


            item2.add(
                Item(
                    R.drawable.wine5, "5 шт", "Солодовый виски\n" +
                            "Jack Daniels", "1 565 000 сум"
                )
            )
            item2.add(
                Item(
                    R.drawable.wine2, "5 шт", "Солодовый виски\n" +
                            "Jack Daniels", "1 565 000 сум"
                )
            )

            val list = ArrayList<OrderHistoryData>()

            list.add(OrderHistoryData("Завершен", "39 000 сум", item))
            list.add(OrderHistoryData("Отменен", "1 565 000 сум", item2))
            list.add(OrderHistoryData("Завершен", "39 000 сум", item))
            list.add(OrderHistoryData("Отменен", "1 565 000 сум", item2))

            return list
        }

        fun getDataSetListList(): List<DataSetList> {
            val list = ArrayList<DataSetList>()

            list.add(DataSetList("https://www.youtube.com/embed/UIXcKIz_UDA","Как сделать заказ и как его отменить"))
            list.add(DataSetList("https://www.youtube.com/embed/UIXcKIz_UDA","Как сменить язык приложения"))
            list.add(DataSetList("https://www.youtube.com/embed/9ouC5a_la4g","Как сделать заказ и как его отменить"))
            list.add(DataSetList("https://www.youtube.com/embed/7YoE0xCMdy0","Как сменить язык приложения"))
            list.add(DataSetList("https://www.youtube.com/embed/8OnXkproxuE","Как сделать заказ и как его отменить"))
            list.add(DataSetList("https://www.youtube.com/embed/2OG0Z7hZQao","Как сменить язык приложения"))
            list.add(DataSetList("https://www.youtube.com/embed/UIXcKIz_UDA","Как сделать заказ и как его отменить"))

            return list
        }
    }

    data class BasketData(
        val imageProduct: Int,
        val productTitle: String,
        val productAbout: String,
        val shopName: String,
        val productCost: String
    )

    data class ProductCategoryData(var image: Int, var product: String)

    data class WineData(var image: Int, var name: String)

    data class SuppliersData(val name: String, val shopName: String)

    data class OrderHistoryData(var buttonText: String, var cost: String, val item: List<Item>)

    data class Item(
        val productImage: Int,
        val count: String,
        val aboutProduct: String,
        val cost: String
    )

    data class HowDoesItWorkData(val name: String)
    data class QuestionAnswerData(val title: String, val body: String)
    data class SupplierListOfData(val name: String, val companyName: String)
    data class AllProducts(
        val img: Int,
        val title: String,
        val textBody: String,
        val companyName: String,
        val price: String,
        val isNew: String,
        var quantity: Int,
        var position: Int
    )

    data class DataSetList(var link: String?, var text:String)

}