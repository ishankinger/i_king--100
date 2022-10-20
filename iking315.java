// CONCEPT OF LINKED LIST (from scratch)

 class LL{                                               // MAIN CLASS 
    
    Node head;                                           // NEW TYPE OF DATATYPE
    private int size;                                    // DEFINING A VARIABLE WITH ACCESS MODIFIER PRIVATE
    
    LL(){                                                // CONSTRUCTOR OF THE CLASS
        this.size=0;                                     // DEFINING VALUE OF VARIABLE LIKE THIS
    }
    class Node{                                          // A NEW CLASS INSIDE MAIN CLASS NAMED NODE
        String data;                                     // DEFINING VARIABLES OF A NODE THAT IS DATA AND NEXT
        Node next;

        Node(String data){                               // CONSTRUCTOR OF NODE CLASS
            this.data= data;                             // MEANS WHEN WE ADD A DATA IT IS STORED AS A NODE AND 
            this.next= null;                             // IT POINTS TOWARDS NULL(EMPTY NODE)
            size++;                                      // THIS MEANS WHEN ONE NODE ADDED SIZE INCREASES BY ONE
        }
    }
    public void addFirst(String data){                   // FUNCTION TO ADD FIRST NODE
            Node newNode= new Node(data);                // DEFINING A VARIABLE FROM CONSTRUCTOR NODE
            if(head==null){                              // TAKING CASE WHEN THERE IS NO LINKED LIST AND THEN THERE WILL BE NO ELEMENT
                head= newNode;                           // IN THAT CASE OUR NEW NODE WILL ITSELF BECOME HEAD
                return;                                  // RETURN TO WRITE
            }                                            // FOR OTHER CASE IF LINKED LIST IS PRESENT THEN
            newNode.next=head;                           // THIS WILL TELL THAT THIS NODE POINTS TOWARDS FIRST NODE OF LIST
            head=newNode;                                // AND NEW HEAD OF LINKED LIST WILL BE NEW NODE THUS ADDED AT FIRST
        }
    public void addLast(String data){                    // FUNCTION TO ADD NODE AT THE LAST OF LINKED LIST
            Node newNode= new Node(data);                // TAKING NODE FROM NODE CONSTRUCTOR
            if(head==null){                              // SIMILAR CONDITION AS THAT OF ABOVE
                head=newNode;
                return;
            }
            Node currNode=head;                          // NOW DEFINING A NEW NODE NAMED AS CURR NODE AS HEAD INITIALISATION
            while(currNode.next!=null){                  // CONDITION TILL THE LOOP HAS TO TRAVERSE
                currNode=currNode.next;                  // TRAVERSING IN THE LINKED LIST WITH THE HELP OF THIS 
            }                                            // OUTSIDE THE LOOP CURRNODE WILL BE LAST AND ITS NEXT WILL BE NULL
            currNode.next=newNode;                       // WHEN CONDITION REACHED THEN LAST NODE WILL BECOME NEW NODE
        }                                              
    public void printList(){                             // FUNCTION TO PRINT THE LINKED LIST
        if(head==null){                                  // SIMILAR TO ABOVE
            System.out.println("list is empty");
        }
            Node currNode=head;                          // SIMILAR CODE TO TRAVERSE IN THE LINKED LIST WITH ONE SLIGHT CHANGE
            while(currNode!=null){                       // HERE TRAVERSE TILL LAST NODE IS NULL THAT IS DIFFERENT FROM ABOVE
             System.out.print(currNode.data + "-->");    // .DATA MEANS THE VALUE OF THAT NODE ASSIGNED
                currNode=currNode.next;                  // TAKE CARE NOT TO WRITE LN IN THIS 
            }
            System.out.println("NULL");
        }
    public void deleteFirst(){                            // FUNCTION TO DELETE FIRST NODE
            if(head==null){                                       
             System.out.println("the list is empty");   // EMPTY AS NO ELEMENT SO WHAT TO DELETE
                return;
            }
            size--;                                        // IF WE DONOT RETURN FROM ABOVE THEN WE HAVE TO DELETE ONE NODE THATS WHY
            head=head.next;                                // MEANS WHEN WE MAKE SECOND NODE AS HEAD FIRST NODE WILL VANISH
        }
    public void deleteLast(){                              // FUNCTION TO DELETE LAST NODE OF LINKED LIST                          
            if(head==null){                                // SIMILAR TO ABOVE
             System.out.println("the list is empty");     
                return;
            }
            size--;                                        // HERE TO WRITE ONLY NOT AT ANY OTHER 
            if(head.next==null){                           // THIS CONDITION WHEN ONLY ONE NODE THEN HEAD WILL BECOME NULL
                head=null;                                 // THIS CONDITION TO BE USED AS IF THIS NOT WRITE THEN IN ABOVE CODE 
                return;                                    // LAST NODE .NEXT WILL SHOW ERROR
            }                                    
            Node secondLast= head;                         // DEFINING NODE AS INITILISATION
            Node lastNode=head.next;                       // NODE NEXT TO ABOVE ONE
            while(lastNode.next!=null){                    // WHEN WE REACH AT THE END
                lastNode=lastNode.next;                    // TILL THAT WE ARE TRAVERSING IN THE LINKED LIST 
                secondLast=secondLast.next;                // MAKING NODES ONE ABOVE ONE
            }
            secondLast.next=null;                          // MEANS WE MAKE SECOND LAST AS LAST NODE BY POINTING TOWARS NULL
        }                                                  // AND AUTOMATICALLY LAST NODE WILL VANISH
    public int getSize(){ 
        if(size==0){
            System.out.println("list is empty");
        }      
            return size;                                   // RETURN THE NET SIZE TILL NOW
        }
    public void reverseIterate(){                          // FUNCTION TO REVERSE A LIST WITH THE HELP OF ITERABLE METHOD
        Node prevNode= head;                               // DEFINING A NODE AS PREV NODE    INITIALISATION
        Node currNode= head.next;                          // DEFINING A CURR NODE
        while(currNode!=null){                             // CURR NODE WILL BECOME NODE THEN ALL ARROWS WILL REVERSE 
            Node nextNode= currNode.next;                  // DEFINIG A NEW NODE NEXT TO CURR NODE
              // POINTS
            currNode.next= prevNode;                       // REVERSING ARROW SO THAT CURRNODE POINTS TOWARDS PREVNODE
              //UPDATE                                     // NOW TAKING LOOP FORWARD VIA DEFINING NEW VARIABLES
            prevNode=currNode;                             // VALUE OF CURRNODE WILL BECOME PREVNODE
            currNode=nextNode;                             // VALUE OF NEXT NODE WILL BECOME CURRNODE
        }                                                  // NOW AT END WHEN CURRNODE EQUAL NULL WE ARE OUT OF LOOP AND ALL REVERSE
        head.next= null;                                   // PREV LIST HEAD WILL POINT TO NULL
        head=prevNode;                                     // FOR NEW LINKED LIST WE ASSIGN NEW HEAD AS PREVNODE THAT IS LAST AS 
    }                                                      // AT THIS STAGE CURR IS NULL AND ITS PRVIOUS WILL BE LAST NODE

    public void getIndex(){                                // FUNCTION TO GET INDEX OF ANY NUMBER
        Node currNode=head;                                // INITIALISATION CURRNODE TO BE HEAD
        int size=0;                                        // SIZE TO BE 0
        while(currNode!=null){                             // TRAVERSING IN THE LINKED LIST TILL WE REACH LAST NODE
            if(currNode.data=="linked"){                   // IF THIS GET AND PRINT SIZE THAT WILL BE ITS INDEX
                System.out.println(size);
                return;
            }else{
            currNode=currNode.next;                         // OTHERWISE KEEP TRAVERSING AND SIZE GET ++
            size++;
        }
      }
    }
    public Node reverseRecursive(Node head){               // REVERSING A LINKEDLIST VIA RECURSIVE APPROACH            
        if(head==null||head.next==null){                   // ALREADY EXPLAINED 
            return head;
        }
        Node newHead= reverseRecursive(head.next);         // CALLING FUNCTION AGAIN AND NEW STACKS FORMED WITH NEW LINKED LIST
        
        head.next.next=head;                               // NOW WHEN WE ARE RETURNING WE WILL USE THIS TO REVERSE
                                                           // HEAD=2 THEN HEAD.NEXT=3 THEN 3.NEXT=2 MEANS REVERSE AND POINT TO 2
        head.next= null;                                   // WHEN IT REVERSE HEAD WILL TO BE POINT TO NULL
        return newHead;                                    // AT END REVERSE OF LIST WILL BE RETURNED
    }
    
    public static void main(String args[]){                // MAIN FUNCTION
        LL list= new LL();                                 // MAKING AN OBJECT FROM THE CLASS
        list.addFirst("this");
        list.addLast("is");
        list.addLast("a");
        list.addLast("linked");
        list.addLast("list");
       // list.deleteLast();
        //list.deleteFirst();
        list.printList();
        System.out.println(list.getSize());
        list.reverseIterate();
        list.printList();
        list.head=list.reverseRecursive(list.head);
        list.printList();
        list.getIndex();
    }
}