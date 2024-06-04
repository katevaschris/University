#include <iostream>
#include <stdlib.h>
#include <random>
#include <chrono>
#include <fstream>
#include <CGAL/basic.h>
#include <CGAL/Exact_predicates_inexact_constructions_kernel.h>
#include <CGAL/Arr_non_caching_segment_traits_2.h>

#include <CGAL/Arr_naive_point_location.h>
#include <CGAL/Arr_landmarks_point_location.h>
#include <CGAL/Arr_walk_along_line_point_location.h>
#include <CGAL/Arr_trapezoid_ric_point_location.h>

#include <CGAL/Cartesian.h>
#include <CGAL/Arr_non_caching_segment_traits_2.h>
#include <CGAL/Arrangement_2.h>

#include <CGAL/IO/Arr_iostream.h>
#include <CGAL/convex_hull_2.h>


#include "arr_inexact_construction_segments.h"
#include "point_location_utils.h"
#include "arr_print.h"


using namespace std;
using namespace std::chrono;


typedef CGAL::Exact_predicates_inexact_constructions_kernel K;
typedef CGAL::Arr_non_caching_segment_traits_2<K> Traits_2;

typedef Traits_2::Point_2 Point;
typedef Traits_2::X_monotone_curve_2 Segment;
typedef CGAL::Arrangement_2<Traits_2> Arrangement;


typedef CGAL::Arr_naive_point_location<Arrangement>        Naive_pl;
typedef CGAL::Arr_landmarks_point_location<Arrangement>     Landmarks_pl;


typedef CGAL::Arr_walk_along_line_point_location<Arrangement> Walk_pl;
typedef CGAL::Arr_trapezoid_ric_point_location<Arrangement>   Trap_pl;



std::random_device r;
std::seed_seq seed{r(), r(), r(), r(), r(), r(), r(), r()};
std::mt19937 eng(seed);
std::uniform_int_distribution<> dist(0, 10000*1000 - 1);

int main()
{
  unsigned long long int n;
  unsigned long long int rndx;
  unsigned long long int rndy;
  int x;
  Arrangement arr;
  
  cout << "Press 1 to load .dat file,or any key to start new arrangement";

  cin >> x;
  if(x != 1)
  {
    cout << "Input range (unsinged log long int) \n";
    cin >> n;

    auto start1 = high_resolution_clock::now();
    // Construct the arrangement.
    

    Point p[n];  
    //produce 1mil cortinates
    for (unsigned long long int i = 0; i < n; ++i)
    {
      rndx = dist(eng);
      rndy = dist(eng);
      p[i] = Point(rndx % n, rndy % n);
    }
    Segment cv[n];
    for (unsigned long long int i = 0; i < n; ++i)
    {
    
      if (i != n - 1)
      {
        cv[i] = Segment(p[i], p[i+1]); 
      }
      else
      {
        cv[i] = Segment(p[i], p[0]);  
      }
    }
    CGAL::insert(arr, cv, cv+n);

    auto stop1 = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop1 - start1);
    cout << "Time taken for 1 : "<< duration.count()/1000000 << " seconds" << endl;

  }
  else
  {
    auto start1 = high_resolution_clock::now();
    ifstream in_file("arr.dat"); // read Arrangement file
    in_file>>arr;
    in_file.close();
    //print_arrangement_size(arr);
    auto stop1 = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop1 - start1);
    cout << "Time taken to load : "<< duration.count()/1000000 << " seconds" << endl;
  }

  
  


  auto start2 = high_resolution_clock::now();

  int vert_num = arr.number_of_vertices(), i=0;
  Point result[vert_num]; 
  Point vertices[vert_num]; 
  for (auto vit = arr.vertices_begin(); vit != arr.vertices_end(); ++vit)
  { 
    vertices[i] = vit->point(); 
    i++;
  }
  Point *ptr = CGAL::convex_hull_2(vertices, vertices+vert_num, result); 
  cout<<ptr - result<<" points on the convex hull:"<<endl;
  for(unsigned long long int i = 0; i < ptr - result; i++)
  {
    cout<<"["<<result[i]<<"]"<<endl; 
  }
  cout << "The arrangement size:\n"
            << "   |V| = " << arr.number_of_vertices()
            << ",  |E| = " << arr.number_of_edges()
            << ",  |F| = " << arr.number_of_faces() << endl;

  auto stop2 = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop2 - start2);
  cout << "Time taken to load : "<< duration.count()/1000000 << " seconds" << endl;
  //save 
  ofstream out_file("arr.dat");
  out_file << arr;
  out_file.close();
 

  while(1)
  {
    unsigned long long int plx, ply;

    cout << "Press 1 to input cordinates to locate: \n";
    cin >> x;
    if (x == 1)
    {
      cin >> plx; 
      cin >> ply;
    }
    else
    {
      cout << "Press random points...";
      cin >> x;
    }
        
    auto start3_1 = high_resolution_clock::now();
    // Perform some point-location queries using the naive strategy.
    Naive_pl naive_pl(arr);
    if(x != 1)
    {
      for (int i = 0; i < x; ++i)
      {
        rndx = dist(eng);
        rndy = dist(eng);
        locate_point(naive_pl, Point(rndx % n, rndy % n));
      }
    }
    else
    {
      locate_point(naive_pl, Point(plx, ply));
    }
    auto stop3_1 = high_resolution_clock::now();
    auto duration3_1 = duration_cast<microseconds>(stop3_1 - start3_1);
    cout << "Time taken by Naive point location: "<< duration3_1.count()/1000000  << " seconds" << endl;


    cout<< "\n";
    auto start3_2 = high_resolution_clock::now();
    Landmarks_pl landmarks_pl(arr);
    if (x != 1)
    {
      for (int i = 0; i < x; ++i)
      {
        rndx = dist(eng);
        rndy = dist(eng);
        locate_point(landmarks_pl, Point(rndx % n, rndy % n));
      }
    }
    else
    {
      locate_point(landmarks_pl, Point(plx, ply));  
    }
    auto stop3_2 = high_resolution_clock::now();
    auto duration3_2 = duration_cast<microseconds>(stop3_2 - start3_2);
    cout << "Time taken by Landmarks point location: "<< duration3_2.count()/1000000  << " seconds" << endl;


    cout<< "\n";
    auto start3_3 = high_resolution_clock::now();
    Walk_pl walk_pl(arr);
    if (x != 1)
    {
      for (int i = 0; i < x; ++i)
      {
        rndx = dist(eng);
        rndy = dist(eng);
        locate_point(walk_pl, Point(rndx % n, rndy % n)); 
      }
    }
    else
    {
      locate_point(walk_pl, Point(plx, ply));
    }
    auto stop3_3 = high_resolution_clock::now();
    auto duration3_3 = duration_cast<microseconds>(stop3_3 - start3_3);
    cout << "Time taken by Walk Along point location: "<< duration3_3.count()/1000000  << " seconds" << endl;



    cout<< "\n";
    auto start3_4 = high_resolution_clock::now();
    Trap_pl trap_pl(arr);
    if (x !=1)
    {
      for (int i = 0; i < x; ++i)
      {
        rndx = dist(eng);
        rndy = dist(eng);
        locate_point(trap_pl, Point(rndx % n, rndy % n));
      }
    }
    else
    {
      locate_point(trap_pl, Point(plx, ply));
    }
    auto stop3_4 = high_resolution_clock::now();
    auto duration3_4 = duration_cast<microseconds>(stop3_4 - start3_4);
    cout << "Time taken by Trapezoid point location: "<< duration3_4.count()/1000000  << " seconds" << endl;
  }
  


  return 0;
}
