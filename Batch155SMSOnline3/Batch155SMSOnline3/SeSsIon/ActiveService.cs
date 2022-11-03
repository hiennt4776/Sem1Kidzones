using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Batch155SMSOnline3.SeSsIon
{
    [Serializable]
    public class ActiveService
    {
        public int serviceID { get; set; }
        public int customerId { get; set; }
        public decimal price { get; set; }
        
        public DateTime starService { get; set; }
        public DateTime endService { get; set; }
    }
}