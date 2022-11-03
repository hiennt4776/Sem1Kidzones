using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp6
{
    class Product
    {
        int id;
        string productName;
        int price;
        string description;
        int categoryId;

        public int Id { get => id; set => id = value; }
        public string ProductName { get => productName; set => productName = value; }
        public int Price { get => price; set => price = value; }
        public string Description { get => description; set => description = value; }
        public int CategoryId { get => categoryId; set => categoryId = value; }
    }
}
