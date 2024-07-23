# CMPT 145 Course material
# Copyright (c) 2017-2024 Michael C Horsch
# All rights reserved.
#
# This document contains resources for homework assigned to students of
# CMPT 145 and shall not be distributed without permission.  Posting this
# file to a public or private website, or providing this file to a person
# not registered in CMPT 145, constitutes Academic Misconduct, according
# to the University of Saskatchewan Policy on Academic Misconduct.
#
# Synopsis: 
#    Assignment nodechain check_chains, copync, double_up

import node as N


def check_chains(chain1, chain2):
    """
    Purpose:
        Checks 2 node chains.  
           If they are identical (the same objects), 
                returns a string "same chain"
           If they are equal (same data values in the same order), 
                returns a string "same values"
           Otherwise, returns a string "different"
    Pre-conditions:
        :param chain1: a node-chain, possibly empty
        :param chain2: a node-chain, possibly empty
    Post-conditions:
        None
    Return:
        :return: a string
    """
    return None




def copync(node_chain):
    """
    Purpose:
        creates a duplicate of the given node chain
    Pre-conditions:
        :param node_chain: a node-chain, possibly empty
    Post-conditions:
        None
    Return:
        :return: a new node chain, a node-for node copy 
                 of the given one
    """
    return None





def double_up(node_chain):
    """
    Purpose:
        Modifies the node chain so that every node is doubled.
        E.g., given 1 -> 2 -> 3
              changed to 1 -> 1 -> 2 -> 2 -> 3 -> 3
    Pre-conditions:
        :param node_chain: a node-chain, possibly empty

    Post-conditions:
        The chain is modified to have each node repeated once.
    Return:
        None
    """
    return None

  