using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp6
{
    class Category
    {
        int id;
        string categoryName;
        string description;

        public int Id { get => id; set => id = value; }
        public string CategoryName { get => categoryName; set => categoryName = value; }
        public string Description { get => description; set => description = value; }
    }
}
